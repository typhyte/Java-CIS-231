import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        myLinkedListTest();
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

        list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
        
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
    }
}
