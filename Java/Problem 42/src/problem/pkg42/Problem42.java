/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Nick
 */
public class Problem42 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        long start = System.nanoTime();
        
        Scanner s = new Scanner(new File("words.txt"));
        
        String[] words = null;
        
        while (s.hasNext()) {
            words = s.next().replaceAll("\"", "").split(",");
        }
        
        int result = 0;
        
        for (String str : words) {
            if (isTriangular(getWordValue(str))) {
                result++;
            }
        }
        
        System.out.println(result);
        System.out.println((System.nanoTime()-start)/1e9);
    }
    
    public static boolean isTriangular(int n) {
        // 8*n + 1 must be an odd perfect square
        double test = Math.sqrt(8*n + 1);
        return (test == (int)test && test % 2 != 0);
    }
    
    // gets the word value for characters in all caps
    public static int getWordValue(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - 64;
        }
        return sum;
    }
}
