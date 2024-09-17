public abstract class Pet {
    int age;
    String species;
    double adoptionPrice;
    double dailyExpenses;
    
    public String toString() {
        return "Age: " + age + "\tSpecies: " + species + "\tAdoption Price: " + adoptionPrice + "\tDaily Expenses: " + dailyExpenses;
    }

    // multiple pets of unknown species
    public void speak(int x) {
        for (int i = 0; i < x; i++) {
            System.out.println("I am just a general pet.");
        }
    }

    // singular pet of unknown species
    public abstract void speak();

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age > 0 && age < 10) {
            this.age = age;
        } else {
            this.age = 2;
        }
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public double getAdoptionPrice() {
        return adoptionPrice;
    }
    public void setAdoptionPrice(double adoptionPrice) {
        this.adoptionPrice = adoptionPrice;
    }
    public double getDailyExpenses() {
        return dailyExpenses;
    }
    public void setDailyExpenses(double dailyExpenses) {
        if (dailyExpenses > 10 && dailyExpenses < 50) {
            this.dailyExpenses = dailyExpenses;
        } else {
            this.dailyExpenses = 10;
        }
    }
}