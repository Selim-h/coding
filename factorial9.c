#include <stdio.h>
#include <time.h>

int linearSearch(int arr[], int n, int key) {
    for(int i = 0; i < n; i++)
        if(arr[i] == key)
            return i;
    return -1;
}

int binarySearch(int arr[], int n, int key) {
    int low = 0, high = n - 1, mid;

    while(low <= high) {
        mid = (low + high) / 2;

        if(arr[mid] == key)
            return mid;
        else if(arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}

int main() {
    int n = 10000;
    int arr[10000];
    int key = 9999;

    for(int i = 0; i < n; i++)
        arr[i] = i;

    clock_t start, end;

    start = clock();
    linearSearch(arr, n, key);
    end = clock();
    printf("Linear Search Time: %lf\n", (double)(end - start)/CLOCKS_PER_SEC);

    start = clock();
    binarySearch(arr, n, key);
    end = clock();
    printf("Binary Search Time: %lf\n", (double)(end - start)/CLOCKS_PER_SEC);

    return 0;
}
