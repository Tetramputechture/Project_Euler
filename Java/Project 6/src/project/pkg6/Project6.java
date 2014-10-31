/*
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural
numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred
natural numbers and the square of the sum.
 */

package project.pkg6;

/**
 *
 * @author Nick
 */
public class Project6 {

    public static int sumSquares(int a) 
    {
        int total = 0;
        for(int i = 2; i <= a; i++)
            total += i*i;
        return total + 1;
    }
    
    public static int squareSums(int a)
    {
        int total = 0;
        for(int i = 1; i <= a; i++)
            total += i;
        return total*total;
    }
    public static void main(String[] args) {
        int i = squareSums(100) - sumSquares(100);
        System.out.println(i);
    }
    
}
