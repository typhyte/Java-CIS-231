import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = MyFile.readFile("DeptSheet.csv");

        list.add("Lance,10,2");
        list.add("Hank,17,1");

        MyFile.writeFile(list, "DeptSheet.csv");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
