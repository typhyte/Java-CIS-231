public class SalariedEmp extends Employee {
    double salary;

    SalariedEmp(String name, String role, int yearsOfService, double taxPercent, double salary) {
        setName(name);
        setRole(role);
        setYearsOfService(yearsOfService);
        setTaxPercent(taxPercent);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 10000) {
            this.salary = salary;
        } else {
            System.out.println("hai this salary is too low");
            this.salary = 10000;
        }
    }

    @Override
    public double getNetPay() {
        return salary - (salary * (taxPercent / 100));
    }

    @Override
    public double getGrossPay() {
        return salary;
    }
}
