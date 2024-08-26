import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Pet> listOfPets = new ArrayList<>();
        char loopContinue = 'y';

        String petName = "";
        int petAge = 0;
        double petPrice = 0.00;

        while (loopContinue == 'y') {
            // get pet data
            System.out.print("What is this pet's name? ");
            petName = input.next();
            System.out.print("What is this pet's age? ");
            petAge = input.nextInt();
            System.out.print("What is this pet's adoption price? ");
            petPrice = input.nextDouble();

            // add pet data to array list
            System.out.println("Adding data...");
            listOfPets.add(new Pet(petName, petAge, petPrice));

            // does user want to continue?
            System.out.print("Do you want to continue? (y/n) ");
            loopContinue = input.next().charAt(0);
        }

        for (int i = 0; i < listOfPets.size(); i++){
            System.out.println("Pet No. " + (i + 1));
            System.out.println(listOfPets.get(i).toString());
        }

        input.close();
    }
}
