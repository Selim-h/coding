#include <stdio.h>
#include <string.h>

int main() {
    char T[100], P[100];
    int i, j, found = -1;

    printf("Enter main string: ");
    scanf("%s", T);

    printf("Enter pattern: ");
    scanf("%s", P);

    int n = strlen(T);
    int m = strlen(P);

    for(i = 0; i <= n - m; i++) {
        for(j = 0; j < m; j++) {
            if(T[i+j] != P[j])
                break;
        }
        if(j == m) {
            found = i;
            break;
        }
    }

    if(found != -1)
        printf("Pattern found at index %d\n", found);
    else
        printf("Pattern not found\n");

    return 0;
}
