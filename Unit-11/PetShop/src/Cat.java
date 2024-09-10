public class Cat extends Pet {
    Cat(int age, double adoptionPrice, double dailyExpenses) {
        setSpecies("Cat");
        setAdoptionPrice(adoptionPrice);
        setDailyExpenses(dailyExpenses);
        setAge(age);
    }

    public void speak() {
        System.out.println("Miau! Meow! :3");
    }
}