public class Employee {
    // properties given by csv
    private int employeeID;
    private String lastName;
    private String firstName;
    private double taxPercent;
    private double hoursWorked;
    private double hoursRate;
        
    // constructor
    public Employee(int employeeID, String lastName, String firstName, double taxPercent, double hoursWorked, double hoursRate) {
        setEmployeeID(employeeID);
        setLastName(lastName);
        setFirstName(firstName);
        setTaxPercent(taxPercent);
        setHoursRate(hoursRate);
        setHoursWorked(hoursWorked);
    }

    // the getters n setters
    public double getHoursRate() {
        return hoursRate;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        if (employeeID > 0) {
            this.employeeID = employeeID;
        } else {
            this.employeeID = (int)(Math.random() * 99 + 1);
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        if (taxPercent > 0 && taxPercent <= 15) {
            this.taxPercent = taxPercent;
        } else {
            this.taxPercent = (int)(Math.random() * 14 + 1);
        }
    }

    public void setHoursRate(double hoursRate) {
        if (hoursRate >= 7.25 && hoursRate <= 50) {
            this.hoursRate = hoursRate;
        } else {
            this.hoursRate = (int)(Math.random() * 42.75 + 7.25);
        }
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked >= 10 && hoursWorked <= 50) {
            this.hoursWorked = hoursWorked;
        } else {
            this.hoursWorked = (int)(Math.random() * 40 + 10);
        }
    }

    public double grossPay() {
        return hoursWorked * hoursRate;
    }

    public double netPay(){
        return grossPay() - (grossPay() * (taxPercent / 100));
    }

    @Override
    public String toString() {
        return employeeID + "," + lastName + "," + firstName + ", " + hoursWorked + "," + hoursRate + "," + grossPay() + "," + taxPercent + "," + netPay(); 
    }
}
