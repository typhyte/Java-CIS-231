public class App {
    public static void main(String[] args) throws Exception {
        MyList list = new MyArrayList<String>();

        System.out.println("Creating entries in array list...");

        list.add("AAAAA");
        list.add("BBBBB");
        list.add("CCCCC");
        list.add("DDDDD");
        list.add("EEEEE");
        displayList(list);

        System.out.println("Adding string \"Hello!\" at index 2 in array...");

        list.add(2, "Hello!");
        displayList(list);

        System.out.println("Removing entry at index 0...");
        
        list.remove(0);
        displayList(list);

        System.out.println("Setting index 1 to string \"ZZZZZ\"...");

        list.set(1, "ZZZZZ");
        displayList(list);

        System.out.println("Checking if list contains \"ZZZZZ\"...");

        if (list.contains("ZZZZZ")) {
            System.out.println("This list contains the string \"ZZZZZ\"!");
        } else {
            System.out.println("This list does not contain the string \"ZZZZZ\".");
        }
        
        System.out.println("Removing all entries...");

        list.removeAll();

        System.out.println("Printing list size...");
        
        System.out.println(list.size());
    }
    //     if (list.indexOf("AAAAA") >= 0) {
    //         System.out.println("The list contains \"AAAAA\"");
    //     } else {
    //         System.out.println("The list does not contain \"AAAAA\"");
    //     }

    //     list.remove(1);
        
    //     for (int i = 0; i < list.size(); i++) {
    //         System.out.println(list.get(i));
    //     }

    //     System.out.println();

    //     list.add(1, "DDDDD");

    //     for (int i = 0; i < list.size(); i++) {
    //         System.out.println(list.get(i));
    //     }

    //     System.out.println();

    //     list.remove("DDDDD");

    //     for (int i = 0; i < list.size(); i++) {
    //         System.out.println(list.get(i));
    //     }
    // }

    public static void displayList(MyList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}
