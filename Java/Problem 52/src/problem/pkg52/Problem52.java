/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg52;

import java.util.Arrays;

/**
 *
 * @author Nick
 */
public class Problem52 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        int i = 125874;
        while (true) {
            int i2 = i * 2;
            int i3 = i * 3;
            if (checkAnagram(i, i2) &&
                    checkAnagram(i, i3)  ) {
                System.out.println(i);
                break;
            }
            i++;
        }
        System.out.println((System.nanoTime()-start)/1e9);
    }

    public static boolean checkAnagram(int x, int y) {
        
        String str1 = String.valueOf(x);
        String str2 = String.valueOf(y);

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
