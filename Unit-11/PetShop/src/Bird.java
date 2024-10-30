public class Bird extends Pet {
    Bird(int age, double adoptionPrice, double dailyExpenses) {
        setSpecies("Bird");
        setAdoptionPrice(adoptionPrice);
        setDailyExpenses(dailyExpenses);
        setAge(age);
    }

    public void speak() {
        System.out.println("Chirp chirp! O>");
    }
}