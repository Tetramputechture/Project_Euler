/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg55;

import java.math.BigInteger;

/**
 *
 * @author Nick
 */
public class Problem55 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int total = 0;
        for (int n = 10; n < 10000; n++) {
            if (isLychrel(n)) {
                total++;
            }
        }

        System.out.println(total);
        System.out.println((System.nanoTime() - start) / 1e9);
    }

    private static boolean isLychrel(int number) {
        BigInteger testNumber = new BigInteger(String.valueOf(number));
        for (int i = 0; i < 50; i++) {
            testNumber = testNumber.add(ReverseNumber(testNumber));
            if (IsPalindrome(testNumber)) {
                return false;
            }
        }
        return true;
    }

    private static BigInteger ReverseNumber(BigInteger number) {
        return new BigInteger(new StringBuilder(number.toString()).reverse().toString());
    }

    private static boolean IsPalindrome(BigInteger number) {
        return number.equals(ReverseNumber(number));
    }

}
