import java.util.ArrayList;

public class App {
    public static void main (String[] args) {
        new App();
    }

    public App(){
        ArrayList<MyPlayer> playerList = populateList();
        showList(playerList);
    }

    public MyPlayer deepCopy(MyPlayer playerToBeCopied) {
        return new MyPlayer(playerToBeCopied.getId(), playerToBeCopied.getName(), playerToBeCopied.getPower());
    }

    public ArrayList<MyPlayer> populateList() {
        ArrayList<MyPlayer> list = new ArrayList<>();

        // create three new players
        MyPlayer p1 = new MyPlayer(0, "theta", 2);
        MyPlayer p2 = new MyPlayer(1, "ada", 14);
        MyPlayer p3 = new MyPlayer(2, "sammie", 12);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        // make deep copy and shadow copy of p3
        MyPlayer p4 = p3.deepCopy();
        MyPlayer p5 = p3;
        list.add(p4);
        list.add(p5);

        return list;
    }

    void showList(ArrayList<MyPlayer> list) {
        // displaying list items
        for (int i=0; i < list.size(); i++) {
            //MyPlayer p = list.get(i)
            System.out.println(list.get(i).toString());
        }
    }
}