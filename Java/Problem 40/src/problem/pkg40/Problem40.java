/*
An irrational decimal fraction is created by concatenating the
positive integers:

0.123456789101112131415161718192021...

It can be seen that the 12th digit of the fractional part is 1.

If dn represents the nth digit of the fractional part, find the value 
of the following expression.

d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
package problem.pkg40;

/**
 *
 * @author Nick
 */
public class Problem40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        String str = "";
        int i = 1;
        while (str.length() <= 1e6) {
            str = sb.append(i).toString();
            i++;
        }
        System.out.println(str);
        int prod = 1;
        for (int n = 10; n <= 1e6; n *= 10) {
            System.out.println(str.charAt(n-1));
            prod *= Character.getNumericValue(str.charAt(n-1));
        }
        System.out.println(prod);
        System.out.println((System.nanoTime()-start)/1e9);
    }
    
}
