public class App {
    public static void main (String[] args) {
        MyPlayer p1 = new MyPlayer(0, "theta", 2);
        MyPlayer p2 = p1;
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
