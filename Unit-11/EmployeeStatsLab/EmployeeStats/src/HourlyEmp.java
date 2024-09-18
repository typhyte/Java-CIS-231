public class HourlyEmp extends Employee{
    int hours;
    double hourlyRate;
    
    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        this.hours = hours;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public double getGrossPay() {
        return hours * hourlyRate;
    }

    public double getNetPay() {
        return getGrossPay() - (getGrossPay() * (taxPercent / 100));
    }
}
