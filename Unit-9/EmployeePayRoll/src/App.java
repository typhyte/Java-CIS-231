import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> inputList = MyFile.readFile("data.csv");
        ArrayList<String> outputList = new ArrayList<>();   
        
        outputList.add("Name\tHours\tRate\tGrossPay");
        for (int i = 0; i < inputList.size(); i++) {
            String fields[] = inputList.get(i).split(",");
            System.out.println(fields[0] + " " + fields[1] + " " + fields[2]);
            
            Employee emp = new Employee(fields[0].trim(), Double.parseDouble(fields[2].trim()), Double.parseDouble(fields[1].trim()));

            outputList.add(emp.toString());
                //System.out.println(inputList.get(i));
        }

        MyFile.writeFile(outputList, "result.csv");
    }
}
