import java.util.Scanner;

public class InputUtils {
    // to prevent invalid format exception error
    public static int getValidInteger(Scanner scan, String message) {
        int num;
        while (true) {
            try {
                System.out.println(message);
                num = Integer.parseInt(scan.nextLine()); // safer than scan.nextInt()
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

}
