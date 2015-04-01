/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg50;

import java.util.ArrayList;

/**
 *
 * @author Nick
 */
public class Problem50 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        ArrayList<Integer> primes = sieve(1000000);
        
        // chain length must be even
        // start subtracting prime numbers while difference > 0
        long maxLength = 0;
        
        for (int i = primes.size()-1; i >= 0; i--) {
            int p = primes.get(i);
            int length = 0;
            int difference = p;
            while (difference > 0) {
                difference -= primes.get(length);
                length++;
            }
            // balance the chain
            int offsetIndex = 0;
            while (difference < 0) {
                difference += primes.get(offsetIndex);
                offsetIndex++;
                length--;
            }
            if (length > maxLength) {
                System.out.println(p);
                maxLength = length;
            }
        }
        
        System.out.println(maxLength);
        
        System.out.println((System.nanoTime()-start)/1e9);
    }

    public static ArrayList<Integer> sieve(int limit) {

        ArrayList<Integer> list = new ArrayList<>();

        boolean[] isComposite = new boolean[limit + 1]; 
        isComposite[1] = true;

        list.add(2);
        // Mark all composite numbers
        for (int i = 3; i <= limit; i += 2) {
            if (!isComposite[i]) {
                // 'i' is a prime number
                list.add(i);
                for (int multiple = 2; i * multiple <= limit; multiple++) {
                    isComposite[i * multiple] = true;
                }
            }
        }

        return list;
    }

}
