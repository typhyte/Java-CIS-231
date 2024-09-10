import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Pet> pet = new ArrayList();

        for (int i = 0; i < 10; i++);
            int num = (int)(Math.random() * 100 + 1) % 3;
            switch (num) {
                case 0:
                    Cat cat1 = new Cat(4, 25, 12.45);
                    pet.add(cat1);
                    break;
                case 1:
                    Dog dog1 = new Dog(4, 35.50, 10.80);
                    pet.add(dog1);
                    break;
                case 2:
                    System.out.println("I am a bird!");
                    Bird bird1 = new Bird(1, 25.50, 20.80);
                    pet.add(bird1);
                    break;
            }

        for (int i = 0; i < pet.size(); i++){
            pet.get(i).speak();
            System.out.println(pet.get(i).toString());
        }
    }
}
