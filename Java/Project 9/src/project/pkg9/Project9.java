/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */

package project.pkg9;

/**
 *
 * @author Nick
 */
public class Project9 {
    
    public static void main(String[] args) {
        int sum = 1000;
        int a;
        int product = 0;
        for(a = 1; a <= sum/3; a++) {
            for(int b = a + 1; b <= sum/2; b++) {
                int c = sum - a - b;
                if(c > 0 && a*a + b*b == c*c)
                    product = a * b * c;
            }
        }  
        System.out.println(product);
    } 
}
