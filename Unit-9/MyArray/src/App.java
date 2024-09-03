import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int sizeOfArray = 0;

        System.out.print("How many indexes do you want your array to have? ");
        while (input.hasNextInt())
        if (input.hasNextInt()) {
            sizeOfArray = input.nextInt();
        } else {
            System.out.println("Oops! That wasn't an integer value!");

        }
    

        int[] userArray = MyArray.populate(sizeOfArray);

        //print out that array!
        MyArray.showArray(userArray);
    }
}
