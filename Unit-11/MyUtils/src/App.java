import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int currentTest = 0;

        System.out.print("Hey! Which util would you like to test?\n[1] Test the MyArrayList class\n[2] Test the MyFile class\n");
        currentTest = input.nextInt();
        
        switch (currentTest) {
            case 1:
                myListTest();
                break;

            case 2:
                myFileTest();
                break;
        }

        input.close();
    }

    public static void myListTest() {
        MyList list = new MyArrayList<String>();

        list.add("AAAAA");
        list.add("BBBBB");
        list.add("CCCCC");

        

        if (list.indexOf("AAAAA") >= 0) {
            System.out.println("The list contains \"AAAAA\"");
        } else {
            System.out.println("The list does not contain \"AAAAA\"");
        }

        list.remove(1);
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();

        list.add(1, "DDDDD");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();

        list.remove("DDDDD");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void myFileTest() {
        ArrayList<String> list = MyFile.readFile("DeptSheet.csv");

        list.add("Lance,10,2");
        list.add("Hank,17,1");

        MyFile.writeFile(list, "DeptSheet.csv");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
