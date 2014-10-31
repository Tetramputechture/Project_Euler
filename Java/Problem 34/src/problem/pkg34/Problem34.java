/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg34;

/**
 *
 * @author Nick
 */
public class Problem34 {
    
    public static int[] facs = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    
    public static boolean check(int n) {

        int sum = 0;
        int t = n;
        
        while (n > 0) {
            sum += facs[n % 10];
            if (sum > t) {
                return false;
            }
            n /= 10;
        }
        
        return sum == t;
        
    }
    
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        long sum = 0;
        
        for (int i = 10; i < facs[9]*7; i++) {
            if (check(i)) {
                sum += i;
            }
        }
        
        System.out.println(sum);
        System.out.println((System.nanoTime() - start)/1e9);
    }
    
}
