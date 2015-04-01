/*
If p is the perimeter of a right angle triangle with integral length sides, 
{a,b,c}, there are exactly three solutions for p = 120.

{20,48,52}, {24,45,51}, {30,40,50}

For which value of p ≤ 1000, is the number of solutions maximised?
 */
package problem.pkg39;

/**
 *
 * @author Nick
 */
public class Problem39 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long start = System.nanoTime();
        
        int[] p = new int[1000];
        
        int N = 400;

        for (int x = 1; x <= N; x++) {
            int y = x + 1;
            int z = y + 1;
            while (z <= N) {
                int zz = x*x + y*y;
                while (z*z < zz) {
                    z++;
                }
                if (z*z == zz && z <= N) {
                    p[x+y+z]++;
                }
                y++;
            }
        }
        
        int max = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > p[max]) {
                max = i;
            }
        }
        System.out.println(max);
        System.out.println((System.nanoTime()-start)/1e9);
    }
    
}
