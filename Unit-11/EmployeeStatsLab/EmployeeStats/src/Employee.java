public class Employee {
    String name;
    String role;
    int yearsOfService;
    double taxPercent;

    Employee() {
    }

    @Override
    public String toString() {
        return "Name: " + name + " Role: " + getRole() + " Net Pay: " + getNetPay() + " Gross Pay: " + getGrossPay();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public double getNetPay() {
        return 0;
    }

    public double getGrossPay() {
        return 0;
    }

    
}
