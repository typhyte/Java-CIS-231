public class Dog extends Pet {
    Dog(int age, double adoptionPrice, double dailyExpenses) {
        setSpecies("Dog");
        setAdoptionPrice(adoptionPrice);
        setDailyExpenses(dailyExpenses);
        setAge(age);
    }

    public void speak() {
        System.out.println("Woof! Woof! :4");
    }
}