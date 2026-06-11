#include <stdio.h>

void matrixMultiplication(int matrix_a[][3], int matrix_b[][3], int M, int P, int N) {
    int matrix_c[10][10];   // simple fixed size
    int i, j, k;

    for (i = 0; i < M; i++) {
        for (j = 0; j < N; j++) {
            matrix_c[i][j] = 0;
            for (k = 0; k < P; k++) {
                matrix_c[i][j] = matrix_c[i][j] + matrix_a[i][k] * matrix_b[k][j];
            }
        }
    }

    for (i = 0; i < M; i++) {
        for (j = 0; j < N; j++) {
            printf("%d ", matrix_c[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int matrix_a[][3] = {{1, -2, 3}, {0, 4, 5}};   // 2 x 3
    int matrix_b[][3] = {{3, 0, -6}, {2, -3, 1}, {2, 5, 3}};  // 3 x 3

    matrixMultiplication(matrix_a, matrix_b, 2, 3, 3);

    return 0;
}
