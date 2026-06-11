
# 🔹 Question 2.1

**Write a program to find the largest element in an array (using goto).**

```c
#include <stdio.h>
#include <string.h>
#include <math.h>

/* -------------------- 2.1 Largest Element (goto) -------------------- */

void LargestElement_Goto(int DATA[], int N)
{
    int K = 0, LOC = 0, MAX = DATA[0];

increment_counter:
    K = K + 1;

    if (K == N)
    {
        printf("LOC = %d, MAX = %d\n", LOC, MAX);
        return;
    }

    if (MAX < DATA[K])
    {
        LOC = K;
        MAX = DATA[K];
    }

    goto increment_counter;
}
```

---

# 🔹 Question 2.2

**Write a program to solve a quadratic equation.**

```c
/* -------------------- 2.2 Quadratic Equation -------------------- */

void QuadraticEquation(int A, int B, int C)
{
    int D = B * B - 4 * A * C;

    if (D > 0)
    {
        float X1 = (-B + sqrt(D)) / (2.0 * A);
        float X2 = (-B - sqrt(D)) / (2.0 * A);
        printf("%f and %f\n", X1, X2);
    }
    else if (D == 0)
    {
        float X = -B / (2.0 * A);
        printf("UNIQUE SOLUTION : %f\n", X);
    }
    else
    {
        printf("NO REAL SOLUTIONS\n");
    }
}
```

---

# 🔹 Question 2.3

**Write a program to find the largest element using while loop.**

```c
/* -------------------- 2.3 Largest Element (while) -------------------- */

void LargestElement_While(int DATA[], int N)
{
    int K = 0, LOC = 0, MAX = DATA[0];

    while (K < N)
    {
        if (MAX < DATA[K])
        {
            LOC = K;
            MAX = DATA[K];
        }
        K = K + 1;
    }

    printf("LOC = %d, MAX = %d\n", LOC, MAX);
}
```

---

# 🔹 Question 2.4

**Write a program to perform linear search.**

```c
/* -------------------- 2.4 Linear Search -------------------- */

void LinearSearch(int DATA[], int N, int ITEM)
{
    int K = 0, LOC = -1;

    while (LOC == -1 && K < N)
    {
        if (ITEM == DATA[K])
            LOC = K;

        K = K + 1;
    }

    if (LOC == -1)
        printf("ITEM is not in array\n");
    else
        printf("%d is the location of ITEM\n", LOC);
}
```

---

# 🔹 Question 3.1

**Write a program to delete a pattern from a string.**

```c
/* -------------------- 3.1 Deletion -------------------- */

int searchPattern(char str[], char pattern[])
{
    int str_len = strlen(str);
    int pat_len = strlen(pattern);

    for (int i = 0; i <= str_len - pat_len; i++)
    {
        int j;
        for (j = 0; j < pat_len; j++)
        {
            if (str[i + j] != pattern[j])
                break;
        }
        if (j == pat_len)
            return i;
    }
    return -1;
}

void erase(char str[], int index, int pat_len)
{
    int i;
    for (i = index; str[i + pat_len] != '\0'; i++)
        str[i] = str[i + pat_len];

    str[i] = '\0';
}
```

---

# 🔹 Question 3.2

**Write a program to replace a pattern in a string.**

```c
/* -------------------- 3.2 Replacement -------------------- */

void insert(char str[], int index, char placeholder[])
{
    char temp[200];
    int i, j = 0;

    for (i = 0; i < index; i++)
        temp[j++] = str[i];

    for (i = 0; placeholder[i] != '\0'; i++)
        temp[j++] = placeholder[i];

    for (i = index; str[i] != '\0'; i++)
        temp[j++] = str[i];

    temp[j] = '\0';
    strcpy(str, temp);
}
```

---

# 🔹 Question 3.3

**Write a program for pattern matching (naive method).**

```c
/* -------------------- 3.3 Pattern Matching -------------------- */

int patternMatching(char str[], char pattern[])
{
    int str_len = strlen(str);
    int pat_len = strlen(pattern);

    for (int i = 0; i <= str_len - pat_len; i++)
    {
        int j;
        for (j = 0; j < pat_len; j++)
        {
            if (str[i + j] != pattern[j])
                break;
        }
        if (j == pat_len)
            return i;
    }
    return -1;
}
```

---

# 🔹 MAIN FUNCTION (Calls Everything)

```c
int main()
{
    int DATA[] = {3, 5, 9, 2};
    int N = 4;

    printf("---- Largest Element (goto) ----\n");
    LargestElement_Goto(DATA, N);

    printf("\n---- Quadratic Equation ----\n");
    QuadraticEquation(1, 2, 1);

    printf("\n---- Largest Element (while) ----\n");
    LargestElement_While(DATA, N);

    printf("\n---- Linear Search ----\n");
    LinearSearch(DATA, N, 9);

    printf("\n---- Deletion ----\n");
    char str1[200] = "To be or not 2B, that is the B,?";
    char pat1[] = "B,";
    int index = searchPattern(str1, pat1);
    while (index != -1)
    {
        erase(str1, index, strlen(pat1));
        index = searchPattern(str1, pat1);
    }
    printf("%s\n", str1);

    printf("\n---- Replacement ----\n");
    char str2[200] = "To be or not 2B, that is the?";
    char pat2[] = "2B";
    char placeholder[] = "to be";
    int idx = searchPattern(str2, pat2);
    erase(str2, idx, strlen(pat2));
    insert(str2, idx, placeholder);
    printf("%s\n", str2);

    printf("\n---- Pattern Matching ----\n");
    char str3[] = "To be or not 2B, that is the ?";
    char pat3[] = "B,";
    printf("Index is : %d\n", patternMatching(str3, pat3));

    return 0;
}
```
