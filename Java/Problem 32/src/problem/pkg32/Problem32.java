/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg32;

import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Nick
 */
public class Problem32 {

    public static boolean isPan(long n) {
        
        int digits = 0;
        int count = 0;
        int tmp;
        
        while (n > 0) {
            tmp = digits;
            digits = digits | 1 << (int)((n % 10) - 1);
            if (tmp == digits) {
                return false;
            }
            
            count++;
            n /= 10;
        }
        
        return digits == (1 << count) - 1;
       
    }
    
    public static long concat(long a, long b) {
        long temp = b;
        while (temp > 0) {
            a *= 10;
            temp /= 10;
        }
        return a + b;  
    }
    
    public static void main(String[] args) {
        
        Set<Integer> products = new TreeSet<>();
        
        long prod, compiled;
        
        for (int i = 2; i < 100; i++) {
            int begin = (i > 9) ? 123 : 1234;
            int end = 10000 / i + 1;
            for (int j = begin; j < end; j++) {
                prod = i*j;
                compiled = concat(concat(prod, j), i);
                if (compiled >= 1E8 &&
                    compiled < 1E9 &&
                    isPan(compiled)) {
                    products.add(i*j);
                }
            }
        }
        
        int sum = products.stream().map((i) -> i).reduce(0, Integer::sum);
        
        System.out.println(sum);
    }
    
}
