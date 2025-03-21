import java.util.Arrays;
import java.util.Scanner;

/**.
* This program will generate 10 random integers on a line
* between 1 and 100 it will then ask for a user number
* and search for that number in the array
* and return the index of the number
*
* @author Remy Skelton
* @version 1.0
* @since 2025-03-18
*/

final class PopulatingArrays {

    /**
     * MAX_ARRAY size variable.
     */
    public static final int MAX_ARRAY = 10;

    /**
     * MAX_VALUE variable.
     */
    public static final int MAX_VALUE = 100;

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private PopulatingArrays() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {
        // Use a scanner to get user input
        Scanner scanner = new Scanner(System.in);

        // initialize the user number string
        String userNumberStr = "";

        // initialize the user number int
        int userNumberInt = 0;

        // initialize the array of random integers
        int[] arrayRandInts = new int[MAX_ARRAY];

        // Do while to run until q is entered
        do {

            // Call the populatingArrays method
            arrayRandInts = populatingArrays();

            // Sort the array of random integers
            Arrays.sort(arrayRandInts);

            // Print the sorted array
            System.out.println("What number are you searching for in "
             + "the list below? Enter 'q' " + "to quit.");

            for (int index = 0; index < MAX_ARRAY; index++) {
                System.out.print(arrayRandInts[index] + " ");
            }
            System.out.print(" Number: ");

            // Get the user input
            userNumberStr = scanner.nextLine();
            // Check if the user entered q
            if (userNumberStr.equals("q")) {
                // Print the goodbye message
                System.out.println("Goodbye!");
            } else {
                // Try catch to catch non-numeric and decinal input
                try {
                // Convert the user input to an int
                    userNumberInt = Integer.parseInt(userNumberStr);

                    // For loop to search for the user number
                    for (int index = 0; index < MAX_ARRAY; index++) {
                        // Check if the user number is in the array
                        if (userNumberInt == arrayRandInts[index]) {
                            // Print the index of the user number
                            System.out.println("The number "
                                    + userNumberInt
                                    + " is found as early as index "
                                    + index);

                            // Break out of the loop
                            break;
                        }

                        // Check if the user number is not in the array
                        if (index == MAX_ARRAY - 1
                        && userNumberInt != arrayRandInts[index]) {
                            // Print the not found message
                            System.out.println("The number "
                                    + userNumberInt
                                    + " was not found in the list.");
                        }
                    }
                } catch (NumberFormatException error) {
                    // Display error message when input is not a number
                    System.out.println("Invalid input: "
                            + userNumberStr
                            + ", Please enter a integer");
                }

            }

        } while (!userNumberStr.equals("q"));
    }

    public static int[] populatingArrays() {
        // initialize the array of random integers
        int[] arrayRandInts = new int[MAX_ARRAY];

        // For loop to add random integers to the array
        for (int index = 0; index < MAX_ARRAY; index++) {
            arrayRandInts[index] = (int) (Math.random() * MAX_VALUE) + 1;
        }
        // Return the array of random integers
        return arrayRandInts;
    }
}
