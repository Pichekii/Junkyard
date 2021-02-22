/**
 * Scott Natelli
 * Assignment 5 - CryptoAnalysis
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "decipher.h"


char main () {
    FILE *fp_K, *fp_T;

    clock_t start_master, end_master;
    char key_file[NAME_LEN] = {0}, text_file[NAME_LEN] = {0}, output[NAME_LEN] = {0}; 
    char cipher_key[KEY_SIZE] = {0}, message[MAX_SIZE] = {0}, escape;
    int menu_choice;

    start_master = clock();
    do {
        /*Propmts the user for the file names of the cipher key, the message, and the output file*/
	printf("What would you like to do?\n\n");
	printf("(1) Decrypt A File\n(2) Encrypt A File\n(3) Exit Program\n\n");
	scanf("%d", &menu_choice);
	if (menu_choice != 3) {
            escape = 'y';
            printf("\n\nEnter the file name for the cipher key: ");
            scanf("%s", key_file);
            printf("\nEnter the file name for the text file: ");
            scanf("%s", text_file);
            printf("\nEnter the name of the text file to be written to: ");
            scanf("%s", output);
	
            /* Calls the file check function. */
            fp_K = fopen(key_file, "r");
            fp_T = fopen(text_file, "r");
            
            /* Checks to see whether the cipher key and the message file exist. */
            if (fp_K == NULL || fp_T == NULL) {
                printf("\n\tERROR! One The File Names Provided Does Not Exist! ERROR!\n\n");
		printf("\tPlease check that the cipher key and text file exist.\n\n");
		printf("\t\t\tPress any key to return to menu.\n\n\n");
		escape = 'n';				
            }
	
            if (escape != 'n') {
                /* Loads the contents of the files into their respective strings. */
		load_files(key_file, text_file, cipher_key, message);
		
                /* Chooses which function the user wanted or to exit. */
		switch (menu_choice) {
                    case 1: {
                        decrypt(output, cipher_key, message);
			printf("\n");
			break;
                    }
                    case 2: {
                        encrypt(output, cipher_key, message);
			printf("\n");	
			break;
                    }
                    case 3:
			break;
		}
            }
	}
    } while (menu_choice != 3);

    end_master = clock();
    printf("\nTotal program runtime (including user input times) is: %g seconds", ((end_master - start_master)/(double)CLOCKS_PER_SEC));
    printf("\n\nPress any key to exit.");
    getch();
    
    return 0;
}



char load_files(char key_file[], char text_file[], char cipher_key[], char message[]) {
    FILE *fp_K, *fp_M;

    char character;
    int element;
	
    /* Clears the strings for the key and the message. */
    for (element = 0; element < KEY_SIZE; element++)
        cipher_key[element] = 0;
    for (element = 0; element < MAX_SIZE; element++)
        message[element] = 0;	

    /* Writes the text files for the key and the message into their respective strings. */
    fp_K = fopen(key_file, "r");
    for (element = 0; element < KEY_SIZE && (character = getc(fp_K)) != EOF; element++)
	cipher_key[element] = tolower(character);
    
    fclose(fp_K);
    fp_M = fopen(text_file, "r");
    
    for (element = 0; element < MAX_SIZE && (character = getc(fp_M)) != EOF; element++)
	message[element] = character;

    fclose(fp_M);	
    return;
}

void decrypt(char output[], char cipher_key[], char message[]) {
    clock_t start_decrypt, end_decrypt;
    char character;
    int element, ele_alph, character_replaced;	

    start_decrypt = clock();

    /**
     * Takes first character and begins decryption process for each individual
     * character. Will check the letters, and decrypt by matching the letter in
     * the message with it's correspondent in the key, and then whatever number
     * it is in the string will be added to the letter 'a' (or 'A').
     */
    for (element = 0; message[element] != EOF && element < MAX_SIZE; element++) {
        character_replaced = 1;
	if (message[element] < 'a') {
            for (character = 'A'; character <= 'Z' && character_replaced != 0; character++) {
                if (character == message[element]) {
                    for (ele_alph = 0; ele_alph < 26; ele_alph++) {
                        if (toupper(cipher_key[ele_alph]) == character) {
                            message[element] = 'A' + ele_alph;
                            character_replaced = 0;
			}
                    }
		}
            }
	} else {
            for (character = 'a'; character <= 'z' && character_replaced != 0; character++) {
                if (character == message[element]) {
                    for (ele_alph = 0; ele_alph < 26; ele_alph++) {
                        if (cipher_key[ele_alph] == character) {
                            message[element] = 'a' + ele_alph;				
                            character_replaced = 0;
			}
                    }
		}
            }
	}
    }

    output_message(output, message);
    end_decrypt = clock();
    printf("\nTotal decryption runtime is: %g second\n", ((end_decrypt - start_decrypt)/(double)CLOCKS_PER_SEC));
}

void encrypt(char output[], char cipher_key[], char message[]) {
    clock_t start_encrypt, end_encrypt;
    char character;
    int element, character_replaced;
	
    start_encrypt = clock();

    /**
     * Same drill as the decryption, except that the character will be replaced
     * with the element of the key string that is the letter in the message
     * minus the letter 'a' (or 'A').
     */
    for (element = 0; message[element] != EOF && element < MAX_SIZE; element++) {
        character_replaced = 1;
        if (message[element] < 'a') {
            for (character = 'A'; character < 'Z' && character_replaced != 0; character++) {
                if (character == message[element]) {
                    message[element] = toupper(cipher_key[character - 'A']);
                    character_replaced = 0;
		}
            }
	} else {
            for (character = 'a'; character < 'z' && character_replaced != 0; character++) {
                if (character == message[element]) {
                    message[element] = cipher_key[character - 'a'];
                    character_replaced = 0;
		}
            }
	}
    }

    output_message(output, message);
    end_encrypt = clock();
    printf("\nTotal encryption runtime is: %g seconds\n", ((end_encrypt - start_encrypt)/(double)CLOCKS_PER_SEC));
}

void output_message(char output[], char message[]) {
    FILE *fp_O;
	
    fp_O = fopen(output, "w");
    fputs(message, fp_O);
    fclose(fp_O);
}
