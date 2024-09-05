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
        int min = num[0];

        for (int i = 0; i < num.length; i++) {
            if (num[i] < min) {
                min = num[i];
            }
        }

        return min;
    }

    public static int maxArray(int[] num) {
        //returns the largest number in a user specified array
        int max = num[0];
        
        for (int i = 0; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }

        return max;
    }

    public static int avgArray(int[] num) {
        // calculates and returns the average of the numbers in
        // an array
        int arraySum = 0;
        int arrayAvg = 0;

        for (int i = 0; i < num.length; i++) {
            arraySum += num[i];
        }

        arrayAvg = arraySum / num.length;
        
        return arrayAvg;
    }

    public static int[] deepCopy(int[] num) {
        // copies a given array into a new array
        int[] deepCopyArray = new int[num.length];

        for (int i = 0; i < num.length; i++) {
            deepCopyArray[i] = num[i];
        }

        return deepCopyArray;
    }

    public static void showArray(int[] num) {
        // prints out a user given array to standard output
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }
}