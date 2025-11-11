import java.util.Arrays;

public class SelectionSortDemo {

    /**
     * Sorts the array of integers using the Selection Sort Algorithm.
     * @param arr The array to be sorted.
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Outer loop: This loop determines the position where the smallest element will be placed.
        // It runs from the first element (i=0) up to the second-to-last element (i < n - 1).
        for (int i = 0; i < n - 1; i++) {
            
            // Assume the current element is the smallest (minimum)
            int min_idx = i;

            // Inner loop: Find the actual minimum element in the remaining UNSORTED array (from i+1 to the end).
            for (int j = i + 1; j < n; j++) {
                // Comparison: If we find a smaller element than the current minimum, update min_idx.
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // After the inner loop finishes, min_idx holds the index of the TRUE smallest element 
            // in the remaining unsorted part.

            // Swap: Perform a single swap to put the minimum element found (at min_idx) 
            // into its correct sorted position (at i).
            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }
            
            // The element at position 'i' is now sorted and will not be checked again.
        }
    }

    public static void main(String[] args) {
        
        // The array from your image
        int[] originalArray = {7, -5, 3, 2, 1, 0, 45}; 
        
        // Create a copy for sorting, so we can display the original
        int[] sortedArray = Arrays.copyOf(originalArray, originalArray.length);

        // --- Display Original Array ---
        System.out.println("Original Array: " + Arrays.toString(originalArray));

        // --- Perform Selection Sort ---
        selectionSort(sortedArray);

        // --- Display Sorted Array ---
        System.out.println("Sorted Array:   " + Arrays.toString(sortedArray));
    }
}