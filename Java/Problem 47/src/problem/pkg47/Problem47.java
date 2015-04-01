/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg47;

import java.util.LinkedList;

/**
 *
 * @author Nick
 */
public class Problem47 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int i = 1;
        while (true) {
            LinkedList<Integer> factorsA = factors(i);
            LinkedList<Integer> factorsB = factors(i - 1);
            LinkedList<Integer> factorsC = factors(i - 2);
            LinkedList<Integer> factorsD = factors(i - 3);
            if (factorsA.size() == 4
                    && factorsB.size() == 4
                    && factorsC.size() == 4
                    && factorsD.size() == 4
                    && !factorsA.equals(factorsB)
                    && !factorsA.equals(factorsC)
                    && !factorsB.equals(factorsC)
                    && !factorsA.equals(factorsD)
                    && !factorsB.equals(factorsD)
                    && !factorsC.equals(factorsD)) {

                System.out.println(i - 3);
                break;
            }
            i++;
        }
        System.out.println((System.nanoTime() - start) / 1e9);
    }

    public static LinkedList<Integer> factors(int numbers) {
        int n = numbers;
        LinkedList<Integer> factors = new LinkedList<>();
        if (n % 2 == 0) {
            factors.add(2);
        }
        for (int i = 3; i <= n / i; i += 2) {
            while (n % i == 0) {
                if (!factors.contains(i)) {
                    factors.add(i);
                }
                n /= i;
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

}
