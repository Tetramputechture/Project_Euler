/*
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
 */
package project.pkg16;

import java.math.BigInteger;

/**
 *
 * @author Nick
 */
public class Project16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BigInteger d = new BigInteger("2");
        BigInteger n = new BigInteger("1");
        
        for(int i = 0; i < 1000; i++) {
            n = n.multiply(d);
        }
        
        String s = String.valueOf(n);
        
        int sumDigits = 0;
        
        for(int i = 0; i < s.length(); i++) {
            sumDigits += Character.getNumericValue(s.charAt(i));
        }
        
        System.out.println(sumDigits);
        
        
    }
    
}
