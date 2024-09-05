import java.util.ArrayList;
    import java.io.BufferedReader;
    import java.io.*;
    
public class MyFile {
    static ArrayList<String> readFile(String fName) {
        ArrayList<String> fileReading = new ArrayList<>();
        
        try {
            File file = new File(fName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;

            while ((st = br.readLine()) != null) {
                fileReading.add(st);
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return fileReading;
    }

    static void writeFile (ArrayList<String> list, String fname) {
        try {
            File file = new File(fname);
            PrintWriter pw = new PrintWriter(file);

            for (int i = 0; i < list.size(); i++) {
                pw.println(list.get(i));
            }
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}