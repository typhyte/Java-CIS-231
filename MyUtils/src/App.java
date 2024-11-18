import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int currentTest = 0;

        System.out.print("Hey! Which util would you like to test?\n[1] Test the MyArrayList class\n[2] Test the MyFile class\n[3] Test the MyLinkedList class\n");
        currentTest = input.nextInt();
        
        switch (currentTest) {
            case 1:
                myListTest();
                break;

            case 2:
                myFileTest();
                break;
            case 3:
                myLinkedListTest();
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

    public static void myLinkedListTest() {
        MyLinkedList list = new MyLinkedList<>();
        list.add("AAAA");
        list.add("BBBB");
        list.add("CCCC");
        list.add("DDDD");
        list.add("EEEE");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println();

        list.add(2, "hai there!");
        
        list.set(1, "new string here >_>");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();

        if (list.contains("hai there!")) {
            System.out.println("This list contains the given string!");
        } else {
            System.out.println("This list does not have the given string.");
        }

        System.out.println("The index of \"new string here >_>\" is " + list.indexOf("new string here >_>"));

        System.out.println();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.removeAll();

        System.out.println(list.size);

        list.remove("BBBB");

        
    }
}
