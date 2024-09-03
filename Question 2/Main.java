/*
 * Name : Samukelo Gift
 * Surname : Msimanga
 * Student Number : 223146145
 * Station Number : 23
 */
import java.util.*;
public class Main {
    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.print("Please enter telephone number in the format: XXX-XXX-XXXX\n"
                + "3-digit code must determine the mobile network to which the number belongs\n"//Used the multi-line string for Readabily
                + "and hyphen between next 3 digits and last 4 digits: "); 
        String telNumber = scanner.nextLine();
        String regexp = "(0[6-8][1-4]|07[689])-[0-9]{3}-[0-9]{4}";// Validate number 06 to 08 followed by any number from 1 to 4, or 07- 
        // any number from 6 to 9m the next 7 digits are just random digits
        boolean telNumberMatches = telNumber.matches(regexp);

        int i = 2;
        while (!telNumberMatches && i > 0) {
            System.out.println("\nEntry is not valid.\n"+(i)+" Attempts remaining");
            System.out.printf("\nPlease enter telephone number in the format: XXX-XXX-XXXX\n"
                    + "3-digit code must determine the mobile network to which the number belongs\n"
                    + "and hyphen between next 3 digits and last 4 digits: ");
            telNumber = scanner.nextLine();
            telNumberMatches = telNumber.matches(regexp);
            i -= 1;
        }
        if (!telNumberMatches)
            System.out.println("\nYou Have Exhausted your Limits, Try Again Next Time! Good Bye :)");
        else {
            String[] telNumberParts = telNumber.split("-");
            String areaCode = telNumberParts[0];
            String network = NetworkFetch(areaCode);
            System.out.printf("\nThank you. Following is the information you entered:\n"
            + "The Phone Number : [%s] is valid\nArea code: %s\nPhone number: %s-%s\nNetwork: %s",telNumber, areaCode, telNumberParts[1], telNumberParts[2], network);
        }
    }
    public static String NetworkFetch(String areaCode) {
        switch (areaCode) {
            case "061":
            case "071":
            case "081":
                return "Telkom Mobile";
            case "062":
            case "072":
            case "076":
            case "079":
            case "082":
                return "Vodacom";
            case "063":
            case "073":
            case "078":
            case "083":
                return "MTN";
            case "064":
            case "074":
            case "084":
                return "Cell C";
            default:
                return "Unknown";
        }
    }
}