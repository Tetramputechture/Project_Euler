/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg59;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Nick
 */
public class bruteforce {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("p059_cipher.txt"));
        String[] arr = sc.next().split(",");
        int[] vals = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            vals[i] = Integer.parseInt(arr[i]);
        }
        
        for (int i = 97; i < 123; i++) {
            for (int j = 97; j < 123; j++) {
                for (int k = 97; k < 123; k++) {
                    int[] key = {i, j, k};
                    for (int c = 0; c < 7; c += 3) {
                        for (int d = 0; d < 3; d++) {
                            System.out.print((char)(vals[c+d] ^ key[d]));
                        }
                    }
                    System.out.println("\n\n\n");
                }
            }
        }
    }
}
