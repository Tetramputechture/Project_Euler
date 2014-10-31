/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project.pkg10;

/**
 *
 * @author Nick
 */
public class Project10 {

    public static void sieveOfEratosthenes(int n) {
        boolean numArray[];
        int sievebound = (n-1)/2;
        
        numArray = new boolean[sievebound];
        for(int i = 1; i < sievebound; i++)
            numArray[i] = true;
        
        long total = 0L;
        
        for(int i = 1; i < (Math.sqrt((double)n)-1)/2; i++)
        {
            if(numArray[i]) 
            {
                for(int j = 2*i*(i+1); j < sievebound; j += 2*i+1)
                    numArray[j] = false;
            }
        }
        
        for(int i = 2; i < sievebound; i++) {
            if(numArray[i]) // if i is prime
                total += 2*i+1;    
        } 
        System.out.println(total);
    }
    
    public static void main(String[] args) {
        long i = System.currentTimeMillis();
        sieveOfEratosthenes(2000000);
        System.out.println(System.currentTimeMillis() - i);
    }  
}
