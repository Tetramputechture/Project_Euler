/*
Starting in the top left corner of a 2×2 grid, and only being able to move
to the right and down, there are exactly 6 routes to the bottom right corner.


How many such routes are there through a 20×20 grid?
 */

package problem.pkg15;

/**
 *
 * @author Nick
 */
public class Problem15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long result = 1;
        
        for(int i = 1; i <= 20; i++) {
            result = (result * (i+20)) / i;
        }
        
        System.out.println(result);
    }
    
}
