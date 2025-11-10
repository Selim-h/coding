#include <stdio.h>

int main() {
    
    long version = __STDC_VERSION__; 
    if (version >= 201710L) {
        printf("You are using C18!\n");
    } 
    else if (version >= 201112L) {
        printf("You are using C11!\n");
    } 
    else if (version >= 199901L) {
        printf("You are using C99!\n");
    }
     else {
        printf("You are using C89/C90!\n");
    }

    return 0;
}

