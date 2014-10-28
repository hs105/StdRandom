public class StdRandomTest {
    private StdRandom rand = new StdRandom(); 

    public void test1() {
        assert rand.floor(2.1) == 2; 
        assert rand.floor(2.9) == 2; 
    }

    public double uniformTest1(int T) {
        int N = 10; 
        int[] count = new int[N]; 

        for (int t = 0;  t < T;  t++) {
            int r = rand.uniform(N); 
            count[r]++; 
        }
        
        double err = 0; 
        int sum = 0; 
        for (int i = 0;  i < count.length;  i++) {
            sum += count[i]; 
            double tmp = count[i]/T- (double) T /N;  
            err +=  tmp*tmp;  
        }
        assert sum == T; 
        return err; 
    }
    
    public void uniformtest2(double a,  double b) {
        for (int t = 0; t < 100; t++) {
            assert rand.uniform(a, b) < b && rand.uniform(a, b) >= a; 
        }
    }

    public void shuffleTest() {
        int[] a = new int[] {0, 1, 3, 4, 2}; 
        rand.shuffle(a); 
        int[] count = new int[5]; 
        for (int i = 0; i < a.length; i++) {
            count[a[i]]++; 
        }
        for (int i = 0; i < a.length; i++) {
            assert count[i] == 1; 
        }

    }

    public static void main(String[] args) {
       StdRandomTest t = new StdRandomTest(); 
       t.test1(); 
       assert t.uniformTest1(10) < t.uniformTest1(100); 
       assert t.uniformTest1(20) < t.uniformTest1(200); 
       assert t.uniformTest1(100) < t.uniformTest1(1000); 
       t.uniformtest2(-10, 10); 
       t.uniformtest2(201, 1000); 

       t.shuffleTest(); 

    }
}
