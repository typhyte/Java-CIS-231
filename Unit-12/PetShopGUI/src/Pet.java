public class Pet {
    String name;
    int age;
    double cost;
    String link;
    
    public Pet(String name, int age, double cost, String link) {
        this.name = name;
        this.age = age;
        this.cost = cost;
        this.link = link;
    }

    public String getLink() {
        return link;
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

    public double getCost() {
        return cost;
    }
    
    public void setCost(double cost) {
        this.cost = cost;
    }
}
