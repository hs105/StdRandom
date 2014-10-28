/*
 a collection of random sampling operations
*/

public class StdRandom {

    /*a real in [0,1) */
    public static double random() {
        return Math.random(); 
    }

    public static int floor(double N) {
        return (int) (N); 
    }

    /* integer between 0 and N-1 */
    public static int uniform(int N) {
        return uniform(0, N); 
    }

    /* integer between low and high-1 */
    public static int uniform(int low,  int high) {
        return low + floor((high-low) * random()); 
    }

    /* real between low and high */
    public static double uniform(double low,  double high) {
        return low + (high-low)*random(); 
    }

    /* sample i with probability a[i] */
    public static int discrete(double[] a) {
        double r = random(); 
        double sum = 0; 
        for (int i = 0; i < a.length; i++) {
            sum += a[i]; 
            if (r < sum) return i; 
        }
        return -1; 
    }

    /* shuffle an array */
    public static void shuffle(int[] a) {
        //exchange a[i] with a random element in a[i...N-1]
        for (int i = 0;  i < a.length;  i++) {
            int j = uniform(i, a.length); 
            int tmp = a[j]; 
            a[j] = a[i]; 
            a[i] = tmp; 
        }
    }
}
