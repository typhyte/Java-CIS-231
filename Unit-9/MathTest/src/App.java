public class App {
    public static void main(String[] args) throws Exception {
        double x = 16.00;
        double ans = MyMath.sqrRoot(x);
        System.out.println("Square root of " + x + " is " + ans);

        int y = 19;
        System.out.println(y + " is a prime number: True or False? " + MyMath.isPrime(y));
    }
}
