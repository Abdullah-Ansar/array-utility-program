import java.util.Scanner;

public class ArrayUtils {
    // Method to find max in an array
    public static int maxOfArray(int[] array) {

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    // Method to print an array
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
    // Method to find min in an array

    public static int minOfArray(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    // Method to Reverse an array

    public static void reverseArray(int[] array, int start, int end) {

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }
        System.out.print("Reversed Array is : ");
        printArray(array);

    }

    public static int isSorted(int[] array) {

        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                descending = false; // Matlab ascending ho sakta hai
            } else if (array[i] > array[i + 1]) {
                ascending = false; // Matlab descending ho sakta hai
            }
        }

        if (ascending)
            return 1; // Ascending order
        else if (descending)
            return 2; // Descending order
        else
            return 0; // Not sorted

    }

    public static int searchArray(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x)
                return i;
        }
        return -1;
    }

    // method to sort the array
    public static void sortArray(int[] array, int choice) {

        if (choice == 1) {
            System.out.println("Original array is : ");
            printArray(array);
            System.out.println("Array in Ascending Order is : ");

            for (int i = 0; i < array.length - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[minIndex] > array[j]) {
                        minIndex = j;
                    }
                }
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

            }
            printArray(array);
        } else if (choice == 2) {
            System.out.println("Original array is : ");
            printArray(array);
            System.out.println("Array in Descending Order is : ");

            for (int i = 0; i < array.length - 1; i++) {
                int maxIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    if (array[maxIndex] < array[j]) {
                        maxIndex = j;
                    }
                }
                int temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;

            }
            printArray(array);
        }
    }

    // method to left rotate by one
    public static void leftRotate(int[] array, int k) {
        System.out.println("Original Array is : ");
        ArrayUtils.printArray(array);

        int n = array.length;
        k = k % n; // incase k>n

        reverseArray(array, 0, k - 1);
        reverseArray(array, k, n - 1);
        reverseArray(array, 0, n - 1);

        System.out.println("Array after left rotating " + x + " x is : ");
        ArrayUtils.printArray(array);
    }

    public static void utilityArray(int option, int[] array, Scanner scan) {

        switch (option) {
            case 1 -> {
                System.out.print("Array is ");
                printArray(array);
                System.out.println();
            }

            case 2 -> {
                System.out.println("Max is : " + maxOfArray(array));
                System.out.println();
            }
            case 3 -> {
                System.out.println("Min is : " + minOfArray(array));
                System.out.println();
            }
            case 4 -> {
                int start = 0;
                int end = array.length - 1;
                int x = InputUtils.getValidInteger(scan, "1.Reverse Whole Array or 2.Reverse Specific indices");
                if (x == 2) {
                    start = InputUtils.getValidInteger(scan, "Enter start index");
                    end = InputUtils.getValidInteger(scan, "Enter end index");
                    if (start < 0 || end >= array.length || start > end) {
                        System.out.println("Invalid index range.");
                        return;
                    }
                } else if (x == 1) {

                } else
                    System.out.println("Invalid Input");
                System.out.print("Original Array is :");
                printArray(array);
                System.out.println();
                reverseArray(array, start, end);
                System.out.println();
            }
            case 5 -> {
                switch (isSorted(array)) {
                    case 1 -> System.out.println("Array is in Ascending Order");

                    case 2 -> System.out.println("Array is in Descending Order");

                    default -> System.out.println("Array is not sorted");

                }
            }
            case 6 -> {
                System.out.println("The Array is :");
                printArray(array);
                System.out.println();
                int x = InputUtils.getValidInteger(scan, "Enter the element that you want to search....");
                int temp = searchArray(array, x);
                if (temp == -1) {
                    System.out.println(x + " is not present in the Array");
                } else
                    System.out.println("Element " + x + " is present at " + temp + " index in the array");
                System.out.println();

            }
            case 7 -> {
                int choice = InputUtils.getValidInteger(scan,
                        "Type 1 to sort in Ascending Order or Type 2 for Descending Order");
                sortArray(array, choice);
                System.out.println();
            }
            case 8 -> {
                int k = InputUtils.getValidInteger(scan, "Enter Number of times :");
                leftRotate(array, k);

            }

            case 0 -> System.out.println("Exiting......");

            default -> System.out.println("Not a valid option");

        }
    }

    // method to clear the screen
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Fallback: simple newlines
            for (int i = 0; i < 50; i++)
                System.out.println();
        }
    }
}