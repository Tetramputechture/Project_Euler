/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg45;

/**
 *
 * @author Nick
 */
public class Problem45 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int i = 143;
        while (true) {
            i++;
            long h = i * (2*i - 1);
            if (isPentagonal(h)) {
                System.out.println(h);
                break;
            }
        }
        System.out.println((System.nanoTime()-start)/1e9);
    }
    
    public static boolean isPentagonal(long n) {
        double x = Math.sqrt(24*n + 1);
        return (int)x == x && x % 6 == 5;
    }
 
}
