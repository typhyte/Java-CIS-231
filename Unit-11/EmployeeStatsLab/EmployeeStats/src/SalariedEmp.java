public class SalariedEmp extends Employee {
    double salary;

    SalariedEmp() {
    }

    public double getNetPay() {
        return salary - (salary * (taxPercent / 100));
    }

    public double getGrossPay() {
        return salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
}
