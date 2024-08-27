import java.util.ArrayList;

public class App {
    public static void main (String[] args) {
        ArrayList<MyPlayer> list = new ArrayList<>();

        MyPlayer p1 = new MyPlayer(0, "theta", 2);
        MyPlayer p2 = new MyPlayer(1, "ada", 14);
        MyPlayer p3 = new MyPlayer(2, "sammie", 12);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        // displaying list items
        for (int i=0; i < list.size(); i++) {
            //MyPlayer p = list.get(i)
            System.out.println(list.get(i).toString());
        }
    }

    public MyPlayer deepCopy(MyPlayer playerToBeCopied) {
        return new MyPlayer(playerToBeCopied.getId(), playerToBeCopied.getName(), playerToBeCopied.getPower());
    }
}