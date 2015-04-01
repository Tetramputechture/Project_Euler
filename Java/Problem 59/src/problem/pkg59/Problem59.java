/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg59;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Nick
 */
public class Problem59 {

    private static class Code {

        private int code;
        private final int index;
        private int freq;

        public Code(int code, int index) {
            this.code = code;
            this.index = index;
            freq = 1;
        }
        
        @Override
        public String toString() {
            return code + " - " + index + " - " + freq;
        }

        @Override
        public boolean equals(Object o) {
            if (o.getClass() != getClass()) {
                return false;
            }
            Code c = (Code) o;
            return code == c.code && index == c.index;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 17 * hash + this.code;
            hash = 17 * hash + this.index;
            return hash;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("p059_cipher.txt"));
        String[] arr = sc.next().split(",");
        int[] vals = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            vals[i] = Integer.parseInt(arr[i]);
        }

        ArrayList<Code> codes = new ArrayList<>();

        for (int i = 0; i < vals.length - 3; i += 3) {
            for (int j = 0; j < 3; j++) {
                // make code
                Code c = new Code(vals[i + j], j);
                // check if code already exists
                if (!codes.contains(c)) {
                    codes.add(c);
                } else {
                    codes.get(codes.indexOf(c)).freq++;
                }
            }
        }

        Collections.sort(codes, (Code c1, Code c2) -> {
            if (c1.freq < c2.freq) {
                return 1;
            }
            if (c1.freq > c2.freq) {
                return -1;
            }
            return 0;
        });
        
        for (int i = 0; i < 3; i++) {
            System.out.println(codes.get(i));
        }
        
        int[] commonLetters = {97, 101, 111};
        
        int[] key = new int[3];
        
        for (int i = 0; i < 3; i++) {
            key[codes.get(i).index] = commonLetters[i] ^ codes.get(i).code;
        }
        
        for (int k : key) {
            if (k < 97 || k > 122) {
                System.out.println("u fucked up");
            }
            System.out.println(k);
        }
        
        for (Code c : codes) {
            c.code ^= key[c.index];
        }
        
        for (int i = 0; i < vals.length - 3; i += 3) {
            for (int j = 0; j < 3; j++) {
                vals[i+j] ^= key[j];
            }
        }
        
        for(int i : vals) {
            System.out.print((char)i);
        }
    }

}
