import java.util.Scanner;

public class BubbleSortDemo {

    // --- Core Bubble Sort Logic (Ascending Order) ---
    public static void bubbleSortAscending(int[] arr) {
        int n = arr.length;
        // Outer loop: controls the number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: performs the comparison and swapping for each pass
            // The largest element "bubbles up" to its correct position (n - 1 - i)
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare adjacent elements
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // --- Core Bubble Sort Logic (Descending Order) ---
    public static void bubbleSortDescending(int[] arr) {
        int n = arr.length;
        // Outer loop: controls the number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: performs the comparison and swapping for each pass
            for (int j = 0; j < n - 1 - i; j++) {
                // Compare adjacent elements
                // The only change is the comparison operator: '<' instead of '>'
                if (arr[j] < arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // --- Helper function to print the array ---
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Input the size of the array
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();

        int[] originalArray = new int[size];

        // 2. Input the array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            originalArray[i] = scanner.nextInt();
        }

        // --- Display Original Array ---
        System.out.print("\nOriginal Array: [");
        printArray(originalArray);

        // --- Ascending Sort ---
        // Create a copy so the original array remains unchanged for the next sort
        int[] ascendingArray = originalArray.clone(); 
        bubbleSortAscending(ascendingArray);

        System.out.print("\nSorted Array (Ascending): [");
        printArray(ascendingArray);

        // --- Descending Sort ---
        // Use the original array again (or a fresh copy)
        int[] descendingArray = originalArray.clone(); 
        bubbleSortDescending(descendingArray);

        System.out.print("Sorted Array (Descending): [");
        printArray(descendingArray);
        
        scanner.close();
    }
}