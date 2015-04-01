/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg53;

/**
 *
 * @author Nick
 */
public class Problem53 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        long total = 0;
        int limit = 1000000;
        
                
        int K = 100;
        int N = 100;
        
        long[][] btable = new long[101][101];

        for (int n = 0; n <= N; n++) {
            btable[n][0] = 1;
        }

        for (int n = 1; n <= N; n++) {
            for (int k = 1; k <= n; k++) {
                btable[n][k] = btable[n - 1][k - 1] + btable[n - 1][k];
                if (btable[n][k] > limit) {
                    btable[n][k] = limit;
                    total++;
                }
            }
        }
       
        System.out.println(total);
        System.out.println((System.nanoTime()-start)/1e9);
    }

}
