/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg19;

/**
 *
 * @author Nick
 */
public class Project19 {
    
    public static int day(int m, int d, int y) {
        
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        
        return (d + x + (31*m0)/12) % 7;
    }
    
    public static boolean isLeap(int y) {
        return (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int numSundays = 0;
        for (int y = 1901; y <= 2000; y++) {
           for (int m = 1; m <= 12; m++) {
               int numDays = 31;
               if (m == 2) {
                   if (isLeap(y)) {
                       numDays = 29;
                   }
                   else numDays = 28;
               } else if (m == 4 || m == 6 || m == 9 || m == 11) {
                   numDays = 30;
               }
               for(int d = 1; d <= numDays; d++) {
                   if(day(m, d, y) == 0 && d == 1) {
                       numSundays++;
                   }
               }
           } 
        }
        System.out.println(numSundays);
    }
    
}
