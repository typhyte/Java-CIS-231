import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        PetProcessor processPet = new PetProcessor();
        ArrayList<Pet> petData = processPet.populatePet("PetStats.csv");
        processPet.showList(petData);
    }
}
