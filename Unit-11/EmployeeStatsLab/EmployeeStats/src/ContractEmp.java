public class ContractEmp extends Employee {
    double monthlyPay;
    int contractDuration; // done in months

    public double getMonthlyPay() {
        return monthlyPay;
    }
    
    public void setMonthlyPay(double monthlyPay) {
        this.monthlyPay = monthlyPay;
    }
    
    public int getContactDuration() {
        return contractDuration;
    }
    
    public void setContactDuration(int contractDuration) {
        this.contractDuration = contractDuration;
    }

    public double getGrossPay() {
        return monthlyPay * contractDuration;
    }

    public double getNetPay() {
        return getGrossPay() - (getGrossPay() * (taxPercent / 100));
    }
}
