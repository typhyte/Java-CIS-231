import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int sizeOfArray = 0;
        
        while (true) {
            try {
                System.out.print("How many indexes do you want your array to have? ");
                sizeOfArray = input.nextInt();
            } catch(InputMismatchException exception) {
                input.nextLine();
            };

            if (sizeOfArray > 0 ) {
                break;
            } else {
                System.out.println("Not a valid input! Please try again.");
            }
        }
        // populate the array
        int[] userArray = MyArray.populate(sizeOfArray);
        System.out.println("Populating array...");
        
        // print out generated array
        MyArray.showArray(userArray);

        // find min, max, and avg of array
        System.out.println("Min: " + MyArray.minArray(userArray) + "\tMax: " + MyArray.maxArray(userArray) + "\tAverage: " + MyArray.avgArray(userArray));

        // deep copy array
        int[] userArrayCopy = MyArray.deepCopy(userArray);
        System.out.println("Copying array...");

        // display deep copy
        MyArray.showArray(userArrayCopy);
    }
}
