/*
We shall say that an n-digit number is pandigital if it makes use of all
the digits 1 to n exactly once. For example,
2143 is a 4-digit pandigital and is also prime.

What is the largest n-digit pandigital prime that exists?
 */
package problem.pkg41;

import eulerutils.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nick
 */
public class Problem41 {
    
    private static boolean result_found = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        findResult("", "7654321", new LinkedList<>());
        System.out.println((System.nanoTime()-start)/1e9);
    }

    private static void findResult(String prefix, String str, List<String> permutations) {
        if (result_found) {
            return;
        }
        int n = str.length();
        if (n == 0) {
            if (EulerUtils.isPrime(Integer.parseInt(prefix))) {
                System.out.println("answer: " + prefix);
                result_found = true;
                return;
            }
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                findResult(prefix + str.charAt(i),
                        str.substring(0, i) + str.substring(i + 1), permutations);
            }
        }
    }
}
