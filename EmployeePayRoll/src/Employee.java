public class Employee {
    private String nameString;
    private double hoursRate;
    private double hoursWorked;
        
    //constructor
    public Employee(String name, double hoursRate, double hoursWorked) {
        setNameString(name);
        setHoursRate(hoursRate);
        setHoursWorked(hoursWorked);
    }

    // the getters
    public String getNameString() {
        return nameString;
    }

    public void setNameString(String nameString) {
        this.nameString = nameString;
    }

    public double getHoursRate() {
        return hoursRate;
    }

    public void setHoursRate(double hoursRate) {
        if (hoursRate >= 0 && hoursRate < 20) {
            this.hoursRate = hoursRate;
        } else {this.hoursRate = 10;}
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked >= 0 && hoursWorked <= 45) {
            this.hoursWorked = hoursWorked;
        } else {this.hoursWorked = 5;}
    }

    public double grossPay() {
        return hoursWorked * hoursRate;
    }

    @Override
    public String toString() {
        return nameString + "\t" + hoursWorked + "\t" + hoursRate + "\t" + grossPay(); 
    }
}
