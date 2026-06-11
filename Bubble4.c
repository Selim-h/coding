#include <stdio.h>

int main() {
    int arr[100], n, key;
    int low = 0, high, mid;
    int found = 0;
    int i;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter sorted elements:\n");
    for(i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
    }

    printf("Enter value to search: ");
    scanf("%d", &key);

    high = n - 1;

    while(low <= high) {
        mid = (low + high) / 2;

        if(arr[mid] == key) {
            printf("Found at position %d", mid+1);
            found = 1;
            break;
        }
        else if(arr[mid] < key)
            low = mid + 1;
        else
            high = mid - 1;
    }

    if(found == 0)
        printf("Not found");

    return 0;
}
