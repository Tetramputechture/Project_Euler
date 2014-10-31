/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg33;

/**
 *
 * @author Nick
 */
public class Problem33 {
    
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        } 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        int denproduct = 1;
        int nomproduct = 1;

        for (int i = 1; i < 10; i++) {
            for (int den = 1; den < i; den++) {
                for (int nom = 1; nom < den; nom++) {
                    if ((nom * 10 + i) * den == nom * (i * 10 + den)) {
                        denproduct *= den;
                        nomproduct *= nom;
                    }
                }
            }
        }
        
        System.out.println(denproduct /= gcd(nomproduct, denproduct));
        System.out.println((System.nanoTime() - start)/1e9);
    }
    
}
