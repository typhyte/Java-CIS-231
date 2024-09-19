import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        EmployeeProcessor empDataProcessor = new EmployeeProcessor();
        ArrayList<Employee> completeEmpData = empDataProcessor.getEmployeeList("EmployeeData.csv");

        empDataProcessor.showEmployeeList(completeEmpData);
    }
}
