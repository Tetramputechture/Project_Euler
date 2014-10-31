/*
Starting with the number 1 and moving to the right in a clockwise direction,
a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers on the diagonals is 101.

What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed
in the same way?
 */
package problem.pkg28;

/**
 *
 * @author Nick
 */

public class Problem28 {
    
    // i used pen and paper to get an algorithm

    public static int sum(int n) {
        return (int)((16.0/3.0)*(int)Math.pow(n, 3) + 10*(int)Math.pow(n, 2) + 26.0/3.0*n + 1);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        System.out.println(sum(500));
    }
    
}
