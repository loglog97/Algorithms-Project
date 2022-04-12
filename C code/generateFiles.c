#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#define NUMFILES 30

/**
 * This is used to generate the files for the assignment
 * 
 * @author Logan Cole
 */

void generateSmall(int length, int i){
    char *filename = malloc(255*sizeof(char));

    int res = sprintf(filename, "smallFiles/small%d.txt", i+1);
    if(res > 0){
        FILE *fp = fopen(filename, "w");
        int count = 0;
        while(count < length){
            fprintf(fp, "%d\n", rand() % 10000);
            count++;
        }
        fclose(fp);
    }
}

void generateMedium(int length, int i){
    char *filename = malloc(255*sizeof(char));
    
    int res = sprintf(filename, "mediumFiles/medium%d.txt", i+1);
    if(res > 0){
        FILE *fp = fopen(filename, "w");
        int count = 0;
        while(count < length){
            fprintf(fp, "%d\n", rand() % 10000);
            count++;
        }
        fclose(fp);
    }
}

void generateLarge(int length, int i){
    char *filename = malloc(255*sizeof(char));
    
    int res = sprintf(filename, "largeFiles/large%d.txt", i+1);
    if(res > 0){
        FILE *fp = fopen(filename, "w");
        int count = 0;
        while(count < length){
            fprintf(fp, "%d\n", rand() % 10000);
            count++;
        }
        fclose(fp);
    }
}
void printPrompt(){
    printf("++++++++++++++++++++++++++\n");
    printf("+++   File generator   +++\n");
    printf("+++ Algorithms project +++\n");
    printf("+++   By: Logan Cole   +++\n");
    printf("++++++++++++++++++++++++++\n\n");
    printf("Type '1' to generate small files\n");
    printf("Type '2' to generate medium files\n");
    printf("Type '3' to generate large files\n");
    printf("Choose an option: ");
}

int main(int argc, char *argv[]){
    int flag = 0;

    printPrompt();
    scanf("%d", &flag);

    /*Not the most efficient but its only 3 options to check */
    if(flag == 1){
        for(int i = 0; i < NUMFILES; i++){
            generateSmall(10000, i);
        }
    }else if(flag == 2){
        for(int i = 0; i < NUMFILES; i++){
            generateMedium(100000, i);
        }
    }else if(flag == 3){
        for(int i = 0; i < NUMFILES; i++){
            generateLarge(1000000, i);
        }
    }else{
        printf("Invalid Number. Try again...\n");
        exit(0);
    }
}