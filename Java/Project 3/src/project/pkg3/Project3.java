/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */

package project.pkg3;
import java.math.BigInteger;

/**
 *
 * @author Nick
 */
public class Project3 {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long p = 600851475143L;
        double m = 3;
        int j;
        while(java.lang.Math.sqrt(m) < p) {
            j = (int)(p % (int)m);
            if(j == 0) {
                p /= m;
                System.out.println(m);
                m += 2;
            }
            else
                m += 2;
        } 
    }
}
    
