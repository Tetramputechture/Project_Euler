/*
Let d(n) be defined as the sum of proper divisors of n (numbers less than n 
which divide evenly into n).

If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and
each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 
1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; 
therefore d(220) = 284. The proper divisors of 284 are 
1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 */
package problem.pkg21;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Nick
 */
public class Problem21 {
    
    public static Map<Integer, Integer> factors = new HashMap<>();

    public static int d(int n) {
        
        int sum = 0;
        
        if (!factors.containsKey(n)) {
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0 && i != n) {
                    sum += i;
                    if (i > 1 && i*i != n) {
                        sum += n/i;
                    }
                }
            }
            factors.put(n, sum);
        }
        else {
            sum = factors.get(n);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        int sum = 0;
        
        for(int i = 2; i < 10000; i++) {
            if (i == d(d(i)) && d(i) != d(d(i))) {
                sum += i;
            }
        }
        
        System.out.println(sum);  
        System.out.println((System.nanoTime() - start)/1e9);
    }
}
