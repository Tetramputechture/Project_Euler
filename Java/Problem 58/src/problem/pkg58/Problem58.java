/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg58;

import eulerutils.EulerUtils;

/**
 *
 * @author Nick
 */
public class Problem58 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int n = 3;
        int numPrimes = 0;
        while (true) {
            long nsquared = n*n;
            for (int i = 1; i < 4; i++) {
                if (EulerUtils.isPrime(nsquared - (n-1)*i)) {
                    numPrimes++;
                }
            }
            
            double ratio = numPrimes/(double)(2*n - 1);
            
            if (ratio < 0.1) {
                break;
            }
            
            n += 2;
        }
        
        System.out.println(n);
        System.out.println((System.nanoTime()-start)/1e9);
    }
    
    
}
