public class Pet {
    private String name;
    private int age;
    private double adoptionCost;

    Pet(){
    }

    Pet(String name, int age, double adoptionCost){
        this.name = name;
        this.age = age;
        this.adoptionCost = adoptionCost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAdoptionCost() {
        return adoptionCost;
    }

    public void setAdoptionCost(double adoptionCost) {
        this.adoptionCost = adoptionCost;
    }

    @Override
    public String toString(){
        return "Pet Name: " + name + "\tPet Age: " + age + "\tPet Adoption Cost: $" + adoptionCost;
    }
}