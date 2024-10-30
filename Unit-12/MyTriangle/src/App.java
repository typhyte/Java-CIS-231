public class App {
    public static void main(String[] args) throws Exception {
        try {
            MyTriangle t1 = new MyTriangle(1, 3, 1);
            double perimeter = t1.getPerimeter();
            
            System.out.println("The perimeter of this triangle is " + perimeter + ".");

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}