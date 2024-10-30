import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> inputList = MyFile.readFile("data.csv");
        ArrayList<String> outputList = new ArrayList<>();   
        
        outputList.add("Employee ID,Last Name,First Name,Hours Worked,Hours Rate,Gross Pay,Tax Rate,Net Pay");
        for (int i = 1; i < inputList.size(); i++) {
            String fields[] = inputList.get(i).split(",");
            //System.out.println(fields[0] + "\t" + fields[1] + "\t" + fields[2] + "\t" + fields[3] + "\t" + fields[4] + "\t" + fields[5]);
            
            System.out.println("Adding employee " + i + "...");
            Employee emp = new Employee(Integer.parseInt(fields[0]), fields[1], fields[2], Double.parseDouble(fields[3]), Double.parseDouble(fields[4]), Double.parseDouble(fields[5]));

            outputList.add(emp.toString());
        }

        System.out.println("Finished! Please check the resulting result.csv and see if everything is correct.");
        MyFile.writeFile(outputList, "result.csv");
    }
}
