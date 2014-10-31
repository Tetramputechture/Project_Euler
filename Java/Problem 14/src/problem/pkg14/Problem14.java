/*
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) contains
10 terms. Although it has not been proved yet (Collatz Problem), it is thought
that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */

package problem.pkg14;

/**
 *
 * @author Nick
 */
public class Problem14 {

    public static long collatzLength(long start) {
        if(start == 1) return 1;
        
        // virtually always ends at 1 
        int sum = 1;
       
        while(start > 1) {
            if(start%2 == 0)
                start /= 2;
            else
                start = (3*start + 1);
            sum++;
        }
        
        return sum;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long max = 0;
        int maxStart = 0;
        for(int n = 1; n < 1e6; n += 3) {
            long length = collatzLength(n);
            if(length > max) {
                max = length;
                maxStart = n;
            }
        }
        System.out.println(maxStart);
    }
    
}
