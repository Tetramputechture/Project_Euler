/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five,
then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out 
in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
letters. The use of "and" when writing out numbers is in compliance with 
British usage.
 */
package project.pkg17;

/**
 *
 * @author Nick
 */
public class Project17 {
    
    public static int countLetters(int n) {
        String[] ones = {"", "one", "two", "three", "four", "five", "six",
                            "seven", "eight", "nine", "ten", "eleven", "twelve",
                            "thirteen", "fourteen", "fifteen", "sixteen", 
                            "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", 
                            "sixty", "seventy", "eighty", "ninety"};
        String[] hundreds = {"", "onehundred", "twohundred", "threehundred", 
                                "fourhundred", "fivehundred", "sixhundred", 
                                "sevenhundred", "eighthundred", "ninehundred"};
        String oneThousand = "onethousand";
        
        int onesPlace = 0;
        int tensPlace = 0;
        int hundredsPlace = 0;
        
        if(n < 20) {
            onesPlace = ones[n].length();
        }
        else if(n >= 20 && n < 1000) {
            if(n % 100 < 20) {
                onesPlace = ones[n % 100].length();
            }
            else {
                onesPlace = ones[n % 10].length();
            }
            tensPlace = tens[(n % 100 - n % 10)/10].length();
            hundredsPlace = hundreds[(n - n % 100)/100].length();
            if(n % 100 != 0 && n > 100)
                hundredsPlace += 3;
        }
        else
            return "onethousand".length();
        
        return hundredsPlace + tensPlace + onesPlace;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int total = 0;
        for(int i = 1; i <= 1000; i++) {
            total += countLetters(i); 
        }
        
        System.out.println(total);
    }
}
