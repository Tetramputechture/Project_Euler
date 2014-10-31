/*
2520 is the smallest number that can be divided by each of the numbers from 1 to
10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the
numbers from 1 to 20?
 */

package project.pkg5;

/**
 *
 * @author Nick
 */
public class Project5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 2;
        int num = 20;
        while(i <= 20) {
            if(num % i == 0) 
                i++;
            else {
                num += 20;    
                i = 2;
            }
        }
        System.out.println(num);
    }
    
}
