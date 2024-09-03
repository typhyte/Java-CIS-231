public class MyArray {
    public static int[] populate(int size) {
        // populates an array with a user specified size
        int[] theArray = new int[size];
        for (int i = 0; i < size; i++) {
            theArray[i] = (int) (Math.random() * 100);
        }

        return theArray;
    };

    public static int minArray(int[] num) {
        // returns the smallest number in a user specified array
        return 1;
    }

    public static int maxArray(int[] num) {
        //returns the largest number in a user specified array
        return 2;
    }

    public static int avgArray(int[] num) {
        // calculates and returns the average of the numbers in
        // an array
        return 1;
    }

    public static int[] deepCopy(int[] num) {
        // copies a given array into a new array
        int[] sample = {1, 2, 3};
        return sample;
    }

    public static void showArray(int[] num) {
        // prints out a user given array to standard output
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}