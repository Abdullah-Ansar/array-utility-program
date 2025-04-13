import java.util.Scanner;

public class Test {
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
        
    }

    
}