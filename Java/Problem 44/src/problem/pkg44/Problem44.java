/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg44;

/**
 *
 * @author Nick
 */
public class Problem44 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int j = 1;
        boolean resultFound = false;
        while (!resultFound) {
            j++;
            int pentJ = j * (3 * j - 1) / 2;
            for (int k = j-1; k > 0; k--) {
                int pentK = k * (3 * k - 1) / 2;
                if (isPentagonal(pentJ - pentK) && isPentagonal(pentJ + pentK)) {
                    System.out.println(pentJ + " " + pentK);
                    System.out.println(pentJ - pentK);
                    resultFound = true;
                    break;
                }
            }
        }
        System.out.println((System.nanoTime()-start)/1e9);
    }
    
    
    public static boolean isPentagonal(int n) {
        return Math.sqrt(24*n + 1) % 6 == 5;
    }
    
}
