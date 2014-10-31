/*
Work out the first ten digits of the sum of the following one-hundred
50-digit numbers. (in file)
 */

package problem.pkg13;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

/**
 *
 * @author Nick
 */
public class Problem13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        
        Scanner in = new Scanner(file);
        
        String[] nums = new String[100];
        
        for(int i = 0; in.hasNext(); i++) {
            nums[i] = in.next();
        }
        
        BigInteger sum = new BigInteger("0");
        
        for(String i : nums) {
            sum = sum.add(new BigInteger(i));
        }
        
        System.out.println(sum);
    }
    
}
