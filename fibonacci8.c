#include <stdio.h>
#include <ctype.h>
#include <string.h>

char stack[100];
int top = -1;

void push(char x) {
    stack[++top] = x;
}

char pop() {
    return stack[top--];
}

int priority(char x) {
    if(x == '+' || x == '-') return 1;
    if(x == '*' || x == '/') return 2;
    if(x == '^') return 3;
    return 0;
}

void infixToPostfix(char exp[]) {
    int i;
    top = -1;

    printf("Postfix: ");

    for(i = 0; exp[i] != '\0'; i++) {

        if(isalnum(exp[i]))
            printf("%c", exp[i]);

        else if(exp[i] == '(')
            push(exp[i]);

        else if(exp[i] == ')') {
            while(stack[top] != '(')
                printf("%c", pop());
            pop();
        }

        else {
            while(top != -1 && priority(stack[top]) >= priority(exp[i]))
                printf("%c", pop());
            push(exp[i]);
        }
    }

    while(top != -1)
        printf("%c", pop());

    printf("\n");
}

void reverse(char exp[]) {
    int i, j;
    char temp;

    for(i = 0, j = strlen(exp)-1; i < j; i++, j--) {
        temp = exp[i];
        exp[i] = exp[j];
        exp[j] = temp;
    }
}

void infixToPrefix(char exp[]) {
    char tempExp[100];
    strcpy(tempExp, exp);

    reverse(tempExp);

    for(int i = 0; tempExp[i] != '\0'; i++) {
        if(tempExp[i] == '(')
            tempExp[i] = ')';
        else if(tempExp[i] == ')')
            tempExp[i] = '(';
    }

    printf("Prefix: ");

    top = -1;
    char output[100];
    int k = 0;

    for(int i = 0; tempExp[i] != '\0'; i++) {

        if(isalnum(tempExp[i]))
            output[k++] = tempExp[i];

        else if(tempExp[i] == '(')
            push(tempExp[i]);

        else if(tempExp[i] == ')') {
            while(stack[top] != '(')
                output[k++] = pop();
            pop();
        }

        else {
            while(top != -1 && priority(stack[top]) >= priority(tempExp[i]))
                output[k++] = pop();
            push(tempExp[i]);
        }
    }

    while(top != -1)
        output[k++] = pop();

    output[k] = '\0';

    reverse(output);

    printf("%s\n", output);
}

int main() {

    char exp[] = "(A+B)*(C-D)";

    printf("Infix: %s\n", exp);

    infixToPostfix(exp);
    infixToPrefix(exp);

    return 0;
}
