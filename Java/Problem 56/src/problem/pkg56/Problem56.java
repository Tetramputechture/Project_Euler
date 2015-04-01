/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg56;

import java.math.BigInteger;

/**
 *
 * @author Nick
 */
public class Problem56 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        long max = 0;
        for (int a = 90; a < 100; a++) {
            BigInteger bigA = new BigInteger(String.valueOf(a));
            for (int b = 90; b < 100; b++) {
                BigInteger i = bigA.pow(b);
                if (digitSum(i) > max) {
                    max = digitSum(i);
                }
            }
        }
        System.out.println(max);
        System.out.println((System.nanoTime() - start) / 1e9);
    }
    
    public static long digitSum(BigInteger n) {
        long res = 0;
        for (char c : n.toString().toCharArray()) {
            res += Character.getNumericValue(c);
        }
        return res;
    }
    
}
