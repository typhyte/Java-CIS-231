import java.io.File;

public class FileLister {
    void showFiles(String dName, String indent) {
        File file = new File(dName);
        int index = dName.lastIndexOf("/");
        System.out.println(indent + dName.substring(index+1));

        if (file.isDirectory()) {
            String[] childFiles = file.list();
            
            for (int i = 0; i < childFiles.length; i++) {
                showFiles(dName + "/" + childFiles[i], indent + "\t");
            }
        }
    }
}
