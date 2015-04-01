/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg49;

import static eulerutils.EulerUtils.isPrime;
import java.util.Arrays;

/**
 *
 * @author Nick
 */
public class Problem49 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 1488; i <= 3333; i++) {
            if (isPrime(i)) {
                int a = i + 3330;
                int b = a + 3330;
                if (isPrime(a)
                        && isPrime(b)
                        && checkAnagram(String.valueOf(i), String.valueOf(a))
                        && checkAnagram(String.valueOf(i), String.valueOf(b))) {
                    System.out.println(i);
                    System.out.println(a);
                    System.out.println(b);
                }
            }
        }
        System.out.println((System.nanoTime() - start) / 1e9);
    }

    public static boolean checkAnagram(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

}
