/*
A palindromic number reads the same both ways. The largest palindrome made from 
the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */

package project.pkg4;

/**
 *
 * @author Nick
 */
public class Project4 {

    /**
     * @param num
     * @return 
     */
    
    public static boolean isPalindrome(int num) {
        String str = Integer.toString(num);
        String reverseStr = "";
        for(int i = str.length() - 1; i >= 0; i--)
            reverseStr += str.charAt(i);
        return reverseStr.equals(str);
    } 
    public static void main(String[] args) {
        int max = 0;
        for(int i = 0; i < 1000; i++) {
            for(int n = 0; n < 1000; n++) {
                if(isPalindrome(i * n)) {
                    if(i*n > max) max = i*n;
                }
            }
        } 
        System.out.println(max);
    } 
}
