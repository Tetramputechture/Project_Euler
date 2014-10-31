/*
Using names.txt, a 46K text file containing over five-thousand first names,
begin by sorting it into alphabetical order. Then working out the alphabetical
value for each name, multiply this value by its alphabetical position in the 
list to obtain a name score.

For example, when the list is sorted into alphabetical order, COLIN, which
is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
would obtain a score of 938 × 53 = 49714.

What is the total of all the name scores in the file?
 */
package problem.pkg22;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Nick
 */
public class Problem22 {
    
    public static int nameScore(String str, int index) {
        
        int score = 0;
        
        for (int i = 0; i < str.length(); i++) {
            score += str.charAt(i) - 64;
        }
        
        return score * index;
    }

    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner f = new Scanner(new File("names.txt")).useDelimiter(",");
        
        List<String> nList = new ArrayList<>();
        while (f.hasNext()) {
            nList.add(f.next());
        }
        
        String[] names = nList.toArray(new String[0]);
        
        Arrays.sort(names);
        
        int totalScore = 0;
        
        int place = 1;
        
        for(String s : names) {
            totalScore += nameScore(s.replace("\"", ""), place);
            place++;
        }
        
        System.out.println(totalScore);
        
    }
    
}
