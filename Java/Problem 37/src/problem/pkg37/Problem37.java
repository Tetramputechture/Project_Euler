/*
The number 3797 has an interesting property. Being prime itself, it is possible 
to continuously remove digits from left to right, and remain prime at each
stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 
3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to 
right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
package problem.pkg37;

import eulerutils.EulerUtils;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nick
 */
public class Problem37 {
    
    private static final List<Integer> primes = EulerUtils.sieve(1000000);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        // only use 3 digits: 3, 7, 9
        // so remove all primes with other numbers in them
        List<Integer> newPrimes = new ArrayList<>();
        
        // 23 and 53 are special cases
        newPrimes.add(23);
        newPrimes.add(53);
        
        for (int i : primes) {
            String s = Integer.toString(i);
            if (!(s.contains("0") || s.contains("2") || s.contains("4") 
                    || s.contains("5") || s.contains("6") || s.contains("8"))) {
                newPrimes.add(i);
            }
        }
        
        
           
        long total = 0;
        
        int numTruncs = 0;
        
        
        for (int i : newPrimes) {
            if (trunc(i)) {
                total += i;
                numTruncs++;
                if (numTruncs > 11) {
                    break;
                }
            }
        }  
        
        System.out.println(total);
        
        System.out.println((System.nanoTime() - start)/1e9);
        
    }
    
    public static boolean trunc(int n) {
        if (n == 2 || n == 3 || n == 5 || n == 7) {
            return false;
        }
        
        int i = 10;
        while (n / i > 0) { 
            if (!primes.contains(n / i)) {
                return false;
            } 
            if (!primes.contains(n % i)) {
                return false;
            } 
            i *= 10;
        }
        
        return true;
    }
}
