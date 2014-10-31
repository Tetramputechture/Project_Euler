/*
In England the currency is made up of pound, £, and pence, p, 
and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
 */
package problem.pkg31;

/**
 *
 * @author Nick
 */
public class Problem31 {
    
    public static int coins[] = {200, 100, 50, 20, 10, 5, 2, 1};

    public static int findpos(int money, int maxcoin) {
        int sum = 0;
        if(maxcoin == 7) return 1;
        for (int i = maxcoin; i < 8; i++) {
            if (money - coins[i] == 0) {
                sum++;
            }
            if (money - coins[i] > 0) {
                sum += findpos(money - coins[i], i);
            }
        }
        return sum;     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(findpos(200, 0));
    }
    
}
