public class App {
    public static void main(String[] args) throws Exception {
        FileLister myLister = new FileLister();
        myLister.showFiles("/home/user/", ""); // replace dName with an actual path (only works on linux filesystems with current config)
    }
}
