/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg46;

/**
 *
 * @author Nick
 */
public class Problem46 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        long result = 0;
        long i = 3;
        while (true) {
            boolean answerFound = true;
            i += 2;
            // only check composite numbers
            if (isPrime(i)) {
                continue;
            }
            long n = 0;
            while (2*(n*n) < i - 1) {
                n++;
                long k = 2*(n*n);
                if (isPrime(i-k)) {
                    answerFound = false;
                    break;
                }
            }
            if (answerFound) {
                break;
            }
        }
        System.out.println("Answer: " + i);
        System.out.printf("Answer found in %s seconds.\n", (System.nanoTime()-start)/1e9);
    }

    public static boolean isPrime(long n) {
        if (n <= 3) {
            return n > 1;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            double sqrtN = (int)(Math.sqrt(n));
            for (int i = 5; i <= sqrtN; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
