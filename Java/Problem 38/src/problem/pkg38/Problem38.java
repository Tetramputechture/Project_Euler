/*
 Take the number 192 and multiply it by each of 1, 2, and 3:

 192 × 1 = 192
 192 × 2 = 384
 192 × 3 = 576
 By concatenating each product we get the 1 to 9 pandigital, 192384576. 
 We will call 192384576 the concatenated product of 192 and (1,2,3)

 The same can be achieved by starting with 9 and multiplying by 
 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the 
 concatenated product of 9 and (1,2,3,4,5).

 What is the largest 1 to 9 pandigital 9-digit number that can be formed as 
 Wthe concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
package problem.pkg38;

public class Problem38 {

    public static void main(String[] args) {
        
        long start = System.nanoTime();

        int max = 0;

        for (int i = 9387; i >= 9234; i--) {
            if (!isPandigital(i) || i % 5 == 0) {
                continue;
            }
            int x = concat(i, i*2);
            if (isPandigital(x)) {
                max = x;
                break;
            }
        }

        System.out.println(max);
        System.out.println((System.nanoTime() - start)/1e9);

    }

    public static int concat(int i, int n) {
        return Integer.parseInt(String.valueOf(i) + String.valueOf(n));
    }

    public static boolean isPandigital(int n) {
        String str = String.valueOf(n);
        if (str.contains("0")) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= (1 << val);
        }
        return true;
    }

}
