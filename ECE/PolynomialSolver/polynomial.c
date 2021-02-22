/**
 * Scott Natelli
 * Assignment 6 - Polynomial Adder_Multiplier_Evaluater
 */

#include <stdio.h>

void sum(char file_name[]);
void product(char file_name[]);
void evaluate(char file_name[]);

struct term {
    float coef;
    int exp;
    struct term *next;
};


void main() {
    FILE *fp_doc;
	
    int num_scheme, choice = 0, response_one = 'N', response_two = 'Y';
    char file_name[80] = {0}, character, num_polys;
	
    do {
    /**
     * The if condition is a gate that determines based on resonse_one after the
     * program has been run once; either for continued operations on the
     * existing file (where this statement is kipped) or to open a new file.
     */ 
	if (response_one == 'N' || response_one == 'n') {
            printf("Enter the file name where the polynomials are found: ");
            scanf("%s", file_name);
            fp_doc = fopen(file_name, "r");
            if (fp_doc == NULL) {
                printf("\n\nERROR! Document Does Not Exist!");
		getch();
		return 0;
            }
	
            /* Outputs all of the polynomial equations found in the file. */
            num_polys = getc(fp_doc);			
            character = getc(fp_doc);
            printf("\nThe polynomials available for operation are:");
            for (num_scheme = 1; character != EOF; num_scheme++) {
                printf("\n%d. ", num_scheme);
		while ((character = getc(fp_doc)) != '\n' && character != EOF) {
                    if (character != EOF)
                    printf("%c", character);
		}
            }
	}
	
        fclose(fp_doc);
	printf("\n\nWhat operation would you like to perform?\n");
	printf("1. ADD Two Polynomials\n");
	printf("2. Multiply Two Polynomials\n");
	printf("3. Evaluate A Polynomial\n");
	printf("4. Exit\n\n");
	printf("Enter your choice: ");
	scanf("%d", &choice);
	
        /* Runs the appropriate function based upon what action the user would like to perform. */
	switch (choice) {
            case 1: {
                sum(file_name);
		break;
            }
            case 2: {
                product(file_name);
		break;
            }
            case 3: {
                evaluate(file_name);
		break;
            }
            case 4:
                exit (0);
            default:
                break;
	}
	
        printf("\n\nDo you wish to perform additional operations on the current file? (Y/N)\n");
	scanf("%s", &response_one);
	
        /**
         * If the user does not wish to continue operations on the current file,
         * the user will be prompted on whether or not they would like to open a
         * new file based upon their response to response_one.
         */
	if (response_one == 'N' || response_one == 'n') {
            printf("\nDo you want to work with another file? (Y/N)?\n");
            scanf("%s", &response_two);
            printf("\n");
	}
    } while(response_two == 'Y' || response_two == 'y');
    
    printf("\n\tThank you for using a product of P.Inc.\tPress any key to quit.");
    getch();
    
    return 0;
}

void sum(char file_name[]) {
    FILE *fp_one, *fp_two;
	
    int poly_one, poly_two, equation;
    char character;
	
    fp_one = fopen(file_name, "r");
    fp_two = fopen(file_name, "r");
    printf("Enter the plynomials that you would like to add: (Example: 1, 2)\n");
    scanf("%d, %d", &poly_one, &poly_two);

    /* Goes to the correct line of the file where the desired polynomial is found. */
    for (equation = 0; equation <= poly_one && character != '\n'; equation++)
        character = getc(fp_one);

    /* Goes to the correct line of the file where the desired polynomial is found. */
    for (equation = 0; equation <= poly_two && character != '\n'; equation++)
        character = getc(fp_two);
    
    fclose(fp_one);
    fclose(fp_two);
}

void product(char file_name[]) {
    FILE *fp_one, *fp_two;
	
    int poly_one, poly_two, equation;
    char character;
	
    fp_one = fopen(file_name, "r");
    fp_two = fopen(file_name, "r");
    printf("Enter the plynomials that you would like to multiply: (Example: 1, 2)\n");
    scanf("%d, %d", &poly_one, poly_two);

    /* Goes to the correct line of the file where the desired polynomial is found. */
    for (equation = 0; equation <= poly_one && character != '\n'; equation++)
        character = getc(fp_one);

    /* Goes to the correct line of the file where the desired polynomial is found. */
    for (equation = 0; equation <= poly_two && character != '\n'; equation++)
        character = getc(fp_two);

    fclose(fp_one);
    fclose(fp_two);
}

void evaluate(char file_name[]) {
    FILE *fp_one, *fp_two;
    struct term *first = NULL, *point;
    struct term *next;

    int poly_one, equation;
    float value;
    char character = 'a', term_array[1500] = {0}, t;
	
    fp_one = fopen(file_name, "r");
    printf("\nEnter the plynomial that you would like to evaluate:\n");
    scanf("%d", &poly_one);
    printf("\nEnter the value that you would like to evaluate:\n");
    scanf("%d", &value);

    /* Goes to the correct line of the file where the desired polynomial is found. */
    for (equation = 0; equation <= poly_one && character != '\n'; equation++)
	character = getc(fp_one);

    /* This is supposed to be where the the polynomial is read into the linked list, but as you can see it's not here. */
    next = malloc(sizeof(struct term));
    fp_two = fp_one;
    point = first;
    point = point->next;
    fscanf(fp_one, "%fx^%d", &point->coef, &point->exp);	
    printf("%f %d", point->coef, point->exp);

    fclose(fp_one);
}
