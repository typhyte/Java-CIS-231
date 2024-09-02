public class MyMath {
    public static double sqrRoot(double num) { 
        double sqrRoot = 1;
        double sqrRoot2 = num/sqrRoot;
        double diff = Math.abs(sqrRoot2-sqrRoot);
        
        while (diff > 0.001){
            sqrRoot = (sqrRoot2+sqrRoot)/2;
            sqrRoot2 = num/sqrRoot;
            diff = Math.abs(sqrRoot2 - sqrRoot);
        }
        return 0.0;
    }
    
    public static boolean isPrime (int num) {
        if (num <= 2) {
            return true;
        } else {
            int rem = num % 2;
            int div = 3;

            while (rem != 0 && div <= num / 2) {
                rem = num % div;
                div += 2;
            }

            return rem != 0;
        }
    }
}