/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg43;

/**
 *
 * @author Nick
 */
public class Problem43 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        
       
        System.out.println((System.nanoTime()-start)/1e9);
    }
    
    public static boolean coPanDigital(int a, int b) {
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        for (int i = 0; i < aStr.length(); i++) {
            if (bStr.contains(String.valueOf(aStr.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
    
}
