import java.util.ArrayList;

public class EmployeeProcessor {
    public ArrayList<Employee> getEmployeeList(String fileName) {
        ArrayList<String> employeeData = MyFile.readFile(fileName);
        ArrayList<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < employeeData.size(); i++) {
            // gets all data from csv and splits each entry into an array
            String info = employeeData.get(i);
            String[] fields = info.split(",");

            int choice = Integer.parseInt(fields[0].trim());

            if (choice == 1) { // employee payed on salary
                SalariedEmp salariedEmployee = new SalariedEmp(fields[1].trim(), // name
                                                               fields[2].trim(), // role
                                                               Integer.parseInt(fields[3].trim()), // years of service
                                                               Double.parseDouble(fields[4].trim()), // tax percent
                                                               Double.parseDouble(fields[5].trim())); // salary
                employeeList.add(salariedEmployee);
            } else if (choice == 2) { // employee payed hourly
                HourlyEmp hourlyEmployee = new HourlyEmp(fields[1].trim(), // name
                                                         fields[2].trim(), // role
                                                         Integer.parseInt(fields[3].trim()), // years of service
                                                         Double.parseDouble(fields[4].trim()), // tax percent
                                                         Integer.parseInt(fields[5].trim()), // hours worked
                                                         Double.parseDouble(fields[6].trim())); // amount payed per hour
                employeeList.add(hourlyEmployee);
            } else if (choice == 3) { // contracted employee
                ContractEmp contractedEmployee = new ContractEmp(fields[1].trim(), // name
                                                                 fields[2].trim(), //role
                                                                 Integer.parseInt(fields[3].trim()), // years of service
                                                                 Double.parseDouble(fields[4].trim()), // tax percent
                                                                 Double.parseDouble(fields[5].trim()), //monthly pay
                                                                 Integer.parseInt(fields[6].trim())); // duration of contract
                employeeList.add(contractedEmployee);
            }
        }

        return employeeList;
    }

    public void showEmployeeList(ArrayList<Employee> empData) {
        for (int i = 0; i < empData.size(); i++) {
            System.out.println(empData.get(i).toString());
        }
    }
}
