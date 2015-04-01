/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg57;

import java.math.BigInteger;

/**
 *
 * @author Nick
 */
public class Problem57 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        
        BigInteger num = new BigInteger("3");
        BigInteger den = new BigInteger("2");
        
        long total = 0;
        
        for (int i = 2; i <= 1000; i++) {
            num = num.add(den.multiply(new BigInteger("2")));
            den = num.subtract(den);
            if (compareDigits(num, den) > 0) {
                total++;
            }
        }
        
        System.out.println(total);
        System.out.println((System.nanoTime()-start)/1e9);
    }
    
    public static int compareDigits(BigInteger a, BigInteger b) {
        int l1 = a.toString().length();
        int l2 = b.toString().length();
        
        if (l1 > l2) {
            return 1;
        }
        if (l1 < l2) {
            return -1;
        }
        return 0;
    }

}
