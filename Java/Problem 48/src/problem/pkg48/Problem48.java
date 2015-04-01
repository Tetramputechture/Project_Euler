/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg48;

import java.math.BigInteger;

/**
 *
 * @author Nick
 */
public class Problem48 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        BigInteger sum = new BigInteger("0");
        
        for (int i = 1; i <= 1000; i++) {
            sum = sum.add(selfPower(i));
        }
        
        System.out.println(sum);
        System.out.println((System.nanoTime()-start)/1e9);
    }
    
    public static BigInteger selfPower(int n) {
        BigInteger N = new BigInteger(String.valueOf(n));
        return N.pow(n);
    }
    
}
