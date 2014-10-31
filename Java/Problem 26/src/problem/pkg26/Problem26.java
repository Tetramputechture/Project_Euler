/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem.pkg26;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Nick
 */
public class Problem26 {
    
    public static int[] convertIntegers(List<Integer> ints) {
        int[] ret = new int[ints.size()];
        Iterator<Integer> iterator = ints.iterator();
        for (int i = 0; i < ret.length; i++) {
            ret[i] = iterator.next();
        }
        return ret;
    }
    
    public static int[] sieveOfEratosthenes(int n) {
        
        boolean numArray[];
        
        numArray = new boolean[n];
        for(int i = 0; i < n; i++)
            numArray[i] = true;
        
        for(int i = 2; i < Math.sqrt((double)n); i++)
        {
            if(numArray[i]) 
            {
                for(int j = (int)Math.pow(i, 2); j < n; j += i)
                    numArray[j] = false;
            }
        }
        
        List<Integer> primeArray = new ArrayList<>();
        
        for(int i = 2; i < n; i++) {
            if(numArray[i]) 
            {
                primeArray.add(i);
            }
        }   
        
        return convertIntegers(primeArray);
    }

    public static int lenCycle(int c, int d) {
        
        System.out.println(d);
        
        int k = 0;
        while (Math.pow(10, k) % d != 0) {
            k++;
        }
        
        return k;
    }
    
    public static void main(String[] args) {

        int[] primes = sieveOfEratosthenes(1000);
        
        int sequenceLength = 0;
        int num = 0;
 
        for (int i = primes.length-1; i >= 0; i--) {
            
            if (sequenceLength >= primes[i]) {
                break;
            }

            int[] foundRemainders = new int[primes[i]];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position;
                value *= 10;
                value %= primes[i];
                position++;
            }

            if (position - foundRemainders[value] > sequenceLength) {
                num = primes[i];
                sequenceLength = position - foundRemainders[value];
            }
        }
        System.out.println(num);
        System.out.println(sequenceLength);
        
    }
}
