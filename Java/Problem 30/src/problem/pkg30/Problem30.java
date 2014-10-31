/*
Surprisingly there are only three numbers that can be written as the sum of
fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written as the sum of fifth
powers of their digits.
 */
package problem.pkg30;

/**
 *
 * @author Nick
 */
public class Problem30 {
    
    // precompute powers of 5 to speed things up (330 ms to 18 ms)
    public static int pow5(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 32;
        } else if (n == 3) {
            return 243;
        } else if (n == 4) {
            return 1024;
        } else if (n == 5) {
            return 3125;
        } else if (n == 6) {
            return 7776;
        } else if (n == 7) {
            return 16807;
        } else if (n == 8) {
            return 32768;
        } else {
            return 59049;
        }
    }
    
    public static boolean check(int n) {
        int temp = n;
        int sum = 0;
        
        while (temp >= 1) {
            int val = temp % 10;
            
            sum += pow5(val);
            if (sum > n) {
                break;
            }
            
            temp /= 10;
        }
        
        return sum == n;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        int sum = 0;
        
        for (int i = 1000; i < 295245; i++) {
            if (check(i)) {
                sum += i;
            }
        }
        
        System.out.println(sum);
        System.out.println((System.nanoTime() - start)/1e9);
    }
    
}
