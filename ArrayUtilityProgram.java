import java.util.*;

public class ArrayUtilityProgram {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ArrayUtils.clearScreen();

        int n = InputUtils.getValidInteger(scan, "Please enter the size of array");
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {

            array[i] = InputUtils.getValidInteger(scan, "Enter number at " + i + " index in array");
        }
        System.out.print("Array is : ");
        ArrayUtils.printArray(array);
        boolean running = true;
        while (running) {
            ArrayUtils.clearScreen();
            System.out.println("\n===========Menu=============");
            System.out.println("Please select an option :");
            System.out.println("1. Print Array");
            System.out.println("2. Find Max");
            System.out.println("3. Find Min");
            System.out.println("4. Reverse Array");
            System.out.println("5. Check if Sorted");
            System.out.println("6. Search Element");
            System.out.println("7. Sort Array");
            System.out.println("8. Left Rotate Array");
            System.out.println("0. Exit");
            int option = InputUtils.getValidInteger(scan, "");
            ArrayUtils.utilityArray(option, array, scan);
            if (option == 0) {
                running = false;
                continue;
            }
            System.out.println("Do you want to exit?");
            int opt = InputUtils.getValidInteger(scan, "Type 0 to Exit, 1 to Continue");
            if (opt == 0) {
                running = false;
                continue;
            }
        }
        System.out.println("Thank you for using me.");
        scan.close();

    }

}