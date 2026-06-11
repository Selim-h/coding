import java.util.*;

public class BubbleSortIO {

    public static void bubbleSort(int[] arr, boolean asc) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (asc ? arr[j] > arr[j + 1] : arr[j] < arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        System.out.println("Original Array: " + Arrays.toString(a));

        int[] asc = Arrays.copyOf(a, a.length);
        int[] desc = Arrays.copyOf(a, a.length);

        bubbleSort(asc, true);
        bubbleSort(desc, false);

        System.out.println("Sorted Ascending : " + Arrays.toString(asc));
        System.out.println("Sorted Descending: " + Arrays.toString(desc));
    }
}
