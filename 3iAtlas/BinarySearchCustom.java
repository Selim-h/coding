import java.util.Scanner;
import java.util.Arrays;

public class BinarySearchCustom {

    /**
     * Implements the Binary Search algorithm iteratively.
     * @param arr The sorted array of integers.
     * @param target The element to search for.
     * @return The index of the target element, or -1 if not found.
     */
    public static int binarySearch(int[] arr, int target) {
        
        // 1. Initialize pointers for the search range
        int low = 0;              // Start at the first index
        int high = arr.length - 1;  // End at the last index

        // 2. Loop until the search space is exhausted (low exceeds high)
        while (low <= high) {
            
            // Calculate the middle index of the current search range
            // (low + high) / 2 is the simplest form, but (low + (high - low) / 2) 
            // is safer to prevent overflow with very large arrays.
            int mid = low + (high - low) / 2;
            
            // 3. Compare the middle element with the target
            if (arr[mid] == target) {
                // Case 1: Target found!
                return mid; 
            } else if (arr[mid] < target) {
                // Case 2: Middle element is less than the target.
                // This means the target must be in the RIGHT (upper) half.
                // Discard the lower half by moving 'low' to one index past 'mid'.
                low = mid + 1; 
            } else { // arr[mid] > target
                // Case 3: Middle element is greater than the target.
                // This means the target must be in the LEFT (lower) half.
                // Discard the upper half by moving 'high' to one index before 'mid'.
                high = mid - 1;
            }
        }
        
        // 4. If the loop finishes, the element was not found
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // --- 1. Input Array ---
        // For simplicity and matching the problem, we will input a fixed sorted array.
        // In a real-world scenario, you would dynamically input elements and sort them first.
        System.out.println("NOTE: Binary Search requires a sorted array.");
        int[] sortedArray = {1, 5, 6, 7, 8, 11};
        System.out.println("Using predefined sorted array: " + Arrays.toString(sortedArray));

        // --- 2. Input Target Element ---
        System.out.print("\nEnter the element to search for: ");
        int targetElement = scanner.nextInt();
        
        // --- 3. Perform Search ---
        int resultIndex = binarySearch(sortedArray, targetElement);
        
        // --- 4. Display Output ---
        System.out.println("\n--- Output ---");
        if (resultIndex != -1) {
            System.out.println(targetElement + " is at index " + resultIndex);
        } else {
            System.out.println("Element " + targetElement + " was not found in the array.");
        }
        
        scanner.close();
    }
}
