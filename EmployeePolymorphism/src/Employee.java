public class Employee {
    String name;
    String role;
    int yearsOfService;
    double taxPercent; // gotten in whole numbers

    @Override
    public String toString() {
        return "Name: " + name + " | Role: " + getRole() + " | Net Pay: " + getNetPay() + " | Gross Pay: " + getGrossPay();
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
        if (yearsOfService >= 0) {
            this.yearsOfService = yearsOfService;
        } else {
            this.yearsOfService = 0;
        }
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        if (taxPercent > 0) {
            this.taxPercent = taxPercent;
        } else {
            this.taxPercent = 7;
        }
    }

    public double getNetPay() {
        return 0;
    }

    public double getGrossPay() {
        return 0;
    }

    
}
