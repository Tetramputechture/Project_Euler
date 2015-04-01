/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg36;

/**
 *
 * @author Nick
 */
public class Problem36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i < 1e6; i++) {
            if (isDoublePalindrome(i)) {
                total += i;
            }
        }
        
        System.out.println(total);
       
    }
    
    public static boolean isDoublePalindrome(int n) {
        String num = Integer.toString(n);
        String bin = Integer.toBinaryString(n);
        return isPalindrome(num) && isPalindrome(bin);
    }
    
    public static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
    
    
}
