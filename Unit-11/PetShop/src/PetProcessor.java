import java.util.ArrayList;

public class PetProcessor {
    public void showList (ArrayList<Pet> petList) {
        // print list
        for (int i = 0; i < petList.size(); i++){
            System.out.println(petList.get(i).toString());
        }
    }

    public ArrayList<Pet> populatePet(String fname) {
        ArrayList<String> petData = MyFile.readFile("PetStats.csv");
        ArrayList<Pet> petList = new ArrayList<>();

        for (int i = 1; i < petData.size(); i++) {
            // get data from row # i and split each field into an array of strings
            String info = petData.get(i);
            String[] fields = info.split(",");
            int choice = Integer.parseInt(fields[0].trim()); // uses the first value to determine pet type

            if (choice == 1) {
                // if the pet id is 1, make a new cat
                Cat cat = new Cat(Integer.parseInt(fields[1].trim()), 
                              Double.parseDouble(fields[2].trim()), 
                              Double.parseDouble(fields[3].trim()));
                
                petList.add(cat);           
            } else if (choice == 2) {
                // if pet id is 2, make dog
                Dog dog = new Dog(Integer.parseInt(fields[1].trim()), 
                              Double.parseDouble(fields[2].trim()), 
                              Double.parseDouble(fields[3].trim()));

                petList.add(dog);
            } else if (choice == 3) {
                // if pet id is 3, make bird
                Bird bird = new Bird(Integer.parseInt(fields[1].trim()), 
                                Double.parseDouble(fields[2].trim()), 
                                Double.parseDouble(fields[3].trim()));

                petList.add(bird);
            }
        }

        // return list of pets
        return petList;
    }
}