/**
 * Java program to generate all unique five-digit numbers using the digits 1, 2, 3, 4, and 5 exactly once.
 * This program uses a simple iterative (nested loop) approach to solve the permutation problem for N=5.
 */
public class UniqueNumberGenerator {

    public static void main(String[] args) {
        // We will store the count of unique numbers found
        int count = 0;

        System.out.println("Generating all unique five-digit numbers using {1, 2, 3, 4, 5}:");
        System.out.println("----------------------------------------------------------------");

        // d1 represents the ten-thousands digit (10000s place)
        for (int d1 = 1; d1 <= 5; d1++) {
            // d2 represents the thousands digit (1000s place)
            for (int d2 = 1; d2 <= 5; d2++) {
                // d3 represents the hundreds digit (100s place)
                for (int d3 = 1; d3 <= 5; d3++) {
                    // d4 represents the tens digit (10s place)
                    for (int d4 = 1; d4 <= 5; d4++) {
                        // d5 represents the units digit (1s place)
                        for (int d5 = 1; d5 <= 5; d5++) {

                            // --- Uniqueness Check ---
                            // This condition ensures that all five digits are distinct (used exactly once).
                            if (d1 != d2 && d1 != d3 && d1 != d4 && d1 != d5 &&
                                d2 != d3 && d2 != d4 && d2 != d5 &&
                                d3 != d4 && d3 != d5 &&
                                d4 != d5) {

                                // --- Construct the number ---
                                // Combine the five unique digits into a single five-digit number.
                                int number = d1 * 10000 + d2 * 1000 + d3 * 100 + d4 * 10 + d5;

                                // Display the number and increment the counter
                                System.out.println(number);
                                count++;
                            }
                        }
                    }
                }
            }
        }

        // --- Final Count ---
        System.out.println("----------------------------------------------------------------");
        System.out.println("Total number of unique five-digit numbers found: " + count);
        
        // Note: For five distinct items, the number of permutations is 5! (5 factorial), which is 120.
    }
}