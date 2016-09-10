#include <cstdio>

int main(int argc, char** argv) {
    char c;
    while (scanf("%c", &c) == 1) {
        if (c != '\n')
            c -= 7;
        printf("%c", c);
    }
    return 0;
}