public class Power {
    public double pow(double x, int n) {
        if (n < 0) {
            return 1 / powHelper(x, -n);
        } else {
            return powHelper(x, n);
        }
    }
     
    private double powHelper(double x, int n) {
    	System.out.println("N is: " + n);
        if (n == 0) return 1;
         
        double v = powHelper(x, n/2);
        System.out.println("V is: " + v);
        
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
    
    public static void main(String[] args) {
    	Power power = new Power();
    	System.out.println(power.pow(10, -4));
    }
}