import java.util.*;

public class SelectionSortDemo {

    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) if (a[j] < a[min]) min = j;
            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

    public static void main(String[] args) {
        // Use the sample array from the question
        int[] arr = { 7, -5, 3, 2, 1, 0, 45 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Sorted  Array: " + Arrays.toString(arr));
    }
}
