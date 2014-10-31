/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg25;

import java.math.BigInteger;

/**
 *
 * @author Nick
 */
public class Problem25 {

    public static final double PHI = 1.6108339887;
    public static final double root5 = 2.2360679775;
    
    public static int fastRound(double n) {
        return (int)(n + 0.5);
    }
    
    public static int nthFib(int n) {
        return fastRound((Math.pow(PHI, n))/root5);
    }
    
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
//        for (int i = 1; i < 30; i++) {
//            System.out.println(i + "nth term: " + nthFib(i));
//        }
        
        BigInteger i = new BigInteger("1");
        BigInteger temp = new BigInteger("0");
        int numDigits = 0;
        int n = 1;
        
        while(numDigits < 1000) {
            i = i.add(temp);
            temp = i.subtract(temp);
            //System.out.println(n + "nth term: " + i);
            numDigits = i.toString().length();
            n++;
        }
      
        System.out.println(n);
        
        System.out.println((System.nanoTime() - start)/1e9);
        
    }
    
}
