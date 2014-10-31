/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
 */
package problem.pkg20;

import java.util.Map;
import java.util.HashMap;
import java.math.BigInteger;

/**
 *
 * @author Nick
 */
public class Problem20 {
    
    public static Map<Integer, BigInteger> fac = new HashMap<>();

    public static BigInteger f(int n) {
        
        BigInteger result = new BigInteger("1");
        
        if(fac.containsKey(n)) {
            return fac.get(n);
        }

        if(n != 1) {
            result = BigInteger.valueOf(n).multiply(f(n-1));
        }
        
        fac.put(n, result);
        return result;
    }
    public static void main(String[] args) {
        long start_time = System.nanoTime();
        String num = f(100).toString();
        int sum = 0;
        for(int i = 0; i < num.length(); i++) {
            sum += Character.getNumericValue(num.charAt(i));
        }
        System.out.println(sum);
        System.out.println("Time: " + (System.nanoTime() - start_time)/1e7);
    }
    
}
