/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */

package project.pkg7;

/**
 *
 * @author Nick
 */
public class Project7 {

    public static void sieveOfEratosthenes(int n)
    {
        boolean numArray[];
        
        numArray = new boolean[n];
        for(int i = 0; i < n; i++)
            numArray[i] = true;
        
        int total = 0;
        
        for(int i = 2; i < Math.sqrt((double)n); i++)
        {
            if(numArray[i]) 
            {
                for(int j = (int)Math.pow(i, 2); j < n; j += i)
                    numArray[j] = false;
            }
        }
        
        for(int i = 2; i < n; i++) {
            if(numArray[i]) 
            {
                total++;
                if(total == 10001)
                    System.out.println(i);
            }
        }   
    }
    
    public static void main(String[] args) {
        sieveOfEratosthenes(110000);
    }
    
}
