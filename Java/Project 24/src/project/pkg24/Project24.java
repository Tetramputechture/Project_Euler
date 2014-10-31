/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg24;

import java.util.Arrays;

/**
 *
 * @author Nick
 */
public class Project24 {
    
    
    // SEPA algorithm
    
    public static void swap(char[] str, int a, int b) { 
        char t = str[a];
        str[a] = str[b];
        str[b] = t;
    }
    
    public static boolean permute(char[] str) {
        
        int len = str.length;
        
        int key = len - 1;
        int newKey = len - 1;
        
        while(key > 0 && str[key] <= str[key-1]) {
            key--;
        }
        
        key--;
        
        if (key < 0) {
            return false;
        }
        
        while(newKey > key && str[newKey] <= str[key]) {
            newKey--;
        }
        
        swap(str, key, newKey);
        
        len--;
        key++;
        
        while (len > key) {
            swap(str, len, key);
            key++;
            len--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        char[] str = "0123456789".toCharArray();
        
        int count = 0;
        do {
            count++;
            if (count == 1e6) {
                break;
            }
        } while (permute(str));
        
        for(char c : str) {
            System.out.print(c);
        }
        
        System.out.println();
        
        System.out.println((System.nanoTime() - start)/1e9);
        
    }  
}
