public class HourlyEmp extends Employee{
    int hours;
    double hourlyRate;
    
    HourlyEmp(String name, String role, int yearsOfService, double taxPercent, int hours, double hourlyRate) {
        setName(name);
        setRole(role);
        setYearsOfService(yearsOfService);
        setTaxPercent(taxPercent);
        setHours(hours);
        setHourlyRate(hourlyRate);
    }

    public int getHours() {
        return hours;
    }
    public void setHours(int hours) {
        if (hours > 20) {
            this.hours = hours;
        } else {
            this.hours = 40;
        }
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate > 7.25) {
            this.hourlyRate = hourlyRate;
        } else {
            this.hourlyRate = 7.25;
        }
    }

    @Override
    public double getGrossPay() {
        return hours * hourlyRate;
    }

    @Override
    public double getNetPay() {
        return getGrossPay() - (getGrossPay() * (taxPercent / 100));
    }
}
