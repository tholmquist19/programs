#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s <argument>\n", argv[0]);
        return 1;
    }

    char *arg = argv[1]; // Get the command line argument

    // Reserve memory to store the argument
    char *reserved_memory = (char *)malloc(strlen(arg) + 1);

    if (reserved_memory == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    // Copy the argument into the reserved memory
    strcpy(reserved_memory, arg);

    // Print the reserved memory
    printf("Reserved memory contains: %s\n", reserved_memory);

    // Free the allocated memory
    free(reserved_memory);

    return 0;
}
