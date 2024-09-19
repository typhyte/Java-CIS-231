public class ContractEmp extends Employee {
    double monthlyPay;
    int contractDuration; // done in months

    ContractEmp(String name, String role, int yearsOfService, double taxPercent, double monthlyPay, int contractDuration) {
        setName(name);
        setRole(role);
        setYearsOfService(yearsOfService);
        setTaxPercent(taxPercent);
        setMonthlyPay(monthlyPay);
        setContactDuration(contractDuration);
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }
    
    public void setMonthlyPay(double monthlyPay) {
        if (monthlyPay > 0) {
            this.monthlyPay = monthlyPay;
        } else {
            this.monthlyPay = 500;
        }
    }
    
    public int getContactDuration() {
        return contractDuration;
    }
    
    public void setContactDuration(int contractDuration) {
        if (contractDuration > 0) {
            this.contractDuration = contractDuration;
        } else {
            this.contractDuration = 6;
        }
    }

    @Override
    public double getGrossPay() {
        return monthlyPay * contractDuration;
    }

    @Override
    public double getNetPay() {
        return getGrossPay() - (getGrossPay() * (taxPercent / 100));
    }
}
