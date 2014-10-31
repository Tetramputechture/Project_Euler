/*
A perfect number is a number for which the sum of its proper divisors is exactly
equal to the number. For example, the sum of the proper divisors of 28 would be 
1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors is less than n 
and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest 
number that can be written as the sum of two abundant numbers is 24. 
By mathematical analysis, it can be shown that all integers greater than 28123 
can be written as the sum of two abundant numbers. However, this upper limit 
cannot be reduced any further by analysis even though it is known that the 
greatest number that cannot be expressed as the sum of two abundant numbers
is less than this limit.

Find the sum of all the positive integers which cannot be written as the sum
of two abundant numbers.
 */
package problem.pkg23;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Nick
 */
public class Problem23 {
   
    public static boolean isAbundant(int n) {
        
        int sum = 0;
       
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (sum > n) {
                return true;
            }
            if (n % i == 0 && i != n) {
                sum += i;
                if (i > 1 && i*i != n) {
                    sum += n/i;
                }
            }
        }
        
        return sum > n;
    }
    
    
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        final int limit = 28123;
        int sum = 0;
       
        List<Integer> aNums = new ArrayList<>();
        
        for (int i = 12; i <= limit; i++) {
            if (isAbundant(i)) {
                aNums.add(i); 
            }
        }
        
        boolean isSum[] = new boolean[limit + 1];
            
        for (int i = 0; i < aNums.size(); i++) {
            for (int j = i; j < aNums.size(); j++) {
                int s = aNums.get(i) + aNums.get(j);
                if (s <= limit) {
                    isSum[s] = true;
                } else {
                    break;
                }
            }
        }
       
        for(int i = 1; i <= limit; i++) {
            if (!isSum[i]) {
                sum += i;
            }
        }
        
        System.out.println(sum);
        System.out.println((System.nanoTime() - start)/1e9);
    }
    
}
