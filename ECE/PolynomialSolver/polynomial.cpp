/**
 * Scott Natelli
 * Assignment 6 - Polynomial Adder_Multiplier_Evaluater
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

class Poly{
    private:
         /* Defines struct node for each node of a Linked List. */
        struct node {
            int exponent;
            double coefficient;
            struct node *next;
	};

	typedef struct node ListNode;
        ListNode *first;

    public:
        /* Adds a new node at end of Linked List with first as pointer to first node. */
        ListNode* Poly::addNode(ListNode *first,int exp,double coeff) {															/*Puts given fields exp and coeff in new node*/
            ListNode *temp, *newNode;
            newNode = (ListNode *)malloc(sizeof(ListNode));
            newNode->exponent = exp;
            newNode->coefficient =  coeff;
            newNode->next =  NULL;
            
            if(first == NULL)
		return newNode;

            temp = first;
            while(temp->next != NULL)
		temp = temp->next;
            
            temp->next = newNode;
	
            return first;
        }

        /* Creates Linked List containing the polynomial given in the file. */
        Poly::Poly(char *str) {
            int exp, sign;
            double coeff;
            char *t, c;
            ListNode *poly=NULL;

            t = strtok(str," ");
	
            if(strcmp(t,"-") == 0) {
                sign = -1;
		t = strtok(NULL," ");
            } else
		sign = 1;
	
            do {
                if(sscanf(t,"%lfx^%d",&coeff,&exp) == 2)
                    ;
		else if(sscanf(t,"x^%d",&exp) == 1)
                    coeff = 1.0;
		else if((sscanf(t,"%lf%c",&coeff,&c) == 2) && (c == 'x'))
			exp = 1;
		else if((sscanf(t,"%c",&c) == 1) && (c == 'x')) {
                    exp = 1;
                    coeff = 1.0;
		} else if(sscanf(t,"%lf",&coeff) == 1)
                    exp = 0;
		else
                    printf("ERROR!\n");
		
                coeff = coeff*sign;
		poly = addNode(poly,exp,coeff);
		if((t=strtok(NULL," ")) == NULL)
                    break;
		if(strcmp(t,"+") == 0)
                    sign = 1;
		else if(strcmp(t,"-") == 0)
                    sign = -1;
		else
                    printf("ERROR!\n");
            } while((t = strtok(NULL," ")) != NULL);
        }

        /* Frees the memory of Linked List list. */
        void Poly::freePoly() {
            ListNode *i = poly, *temp;
            while(i != NULL) {
                temp = i;
		i = i->next;
		free(temp);
            }
	
            return;
        }

        /* Adds two polynomials given in Linked Lists poly1 and poly2. */
        ListNode* Poly::addPoly(ListNode *poly2) {
            ListNode *i = poly1, *j = poly2, *sum = NULL;			
            double coeff;

            while((i != NULL) && (j != NULL)) {
                if(i->exponent > j->exponent) {
                    sum = addNode(sum, i->exponent, i->coefficient);	/* Each time term with largest exponent is selected and added to sum. */															
                    i = i->next;					/* If both polynomials have term with same exponent, term with this exponent and coefficient as sum of the 2 coefficients is added to sum. */
		} else if(j->exponent > i->exponent) {			/* If coefficient turns out to be zero, no term is added to sum. */
                    sum = addNode(sum, j->exponent, j->coefficient);
                    j = j->next;
		} else {
                    coeff = i->coefficient + j->coefficient;
                    if(coeff!=0)
                        sum = addNode(sum, i->exponent, coeff);
                    j = j->next;
                    i = i->next;
		}
            }
	
            while(i != NULL) {
                sum = addNode(sum, i->exponent, i->coefficient);
		i = i->next;
            }
	
            while(j != NULL) {
                sum = addNode(sum, j->exponent, j->coefficient);
		j = j->next;
            }
	
            return sum;
        }

        /**
         * Multiplies two polynomials given in Linked Lists poly1 and poly2.
         * Returns Linked List containing the Product.
         */
        ListNode* Poly::multiplyPoly(Poly *poly2) {
            Poly *i = poly1, *j = poly2, *product = NULL, *partialProduct = NULL, *temp;
            int exp;
            double coeff;

            while(i != NULL) {
                partialProduct = NULL;      /* Create each partialProduct as 1 term of poly1 multiplied with poly2. */
		j = poly2;                  /* And this partialProduct is added to Product. */
		while(j != NULL) {          /* Product will accumulate all partial product to get product of 2 polynomials. */
                    exp = i->exponent + j->exponent;
                    coeff = i->coefficient * j->coefficient;
                    partialProduct = addNode(partialProduct, exp, coeff);
                    j = j->next;
		}
                
		temp = product;
		product = addPoly(product, partialProduct);
		temp->freePoly();
		partialProduct = freePoly(partialProduct);
		i = i->next;
            }
            
            return product;
        }

        /* Prints the polynomial given by Linked List list in proper format. */
        void Poly::printPoly() {
            ListNode *i = poly;

            if(poly == NULL) {
                printf("0\n");
                return;
            }

            while(i != NULL) {
                printf("%g", i->coefficient);
                if(i->exponent > 0)
                    printf("x");
                if(i->exponent > 1)
                    printf("^%d", i->exponent);
                if(i->next != NULL)
                    printf(" + ");
                i = i->next;
            }
            printf("\n");
        }

        /**
         * evalPoly value of poynomial given by Linked List list at x = xvalue
         * Returns this evalPolyd value of the polynomial.
         */
        double Poly::evalPoly(ListNode *poly, double xvalue) {
            ListNode *i = poly;
            double polyValue = 0.0;

            while(i != NULL) {
                polyValue = polyValue + (i->coefficient * pow(xvalue, i->exponent));
                i = i->next;
            }
            return polyValue;
        }

        /**
         * Checks if fp points to a valid file (that is, if file given in fopen() exists).
         * Gives error message and exits is file could not be opened.
         */
        int Poly::checkValidFile(FILE *fp) {
            if(fp == NULL) {
                printf("\nCan't Open File!\n");
                printf("Try Again.\n\n");
                return 0;
            }

            return 1;
        }
};


int main() {
    Poly *poly1, *poly2, *temp = NULL, *sum, *product;
    FILE *fp;
    int choice = 0, exp = 0, N, i, n1, n2;
    double coeff = 0, xvalue, polyValue;
    char filename[30], str[2000], str_temp[2000];
    char **poly_strings, ch;

    while(1) {
        printf("\nEnter the file where polynomials are found: ");
	scanf("%s", filename);
	while(getchar() != '\n');
	fp = fopen(filename, "r");
	if(!checkValidFile(fp))
            continue;
	printf("\nThe polynomials available for operation are:\n");
	fscanf(fp, "%d", &N);
	fgets(str, 2000, fp);
	poly_strings = (char **)malloc(N*sizeof(char *));
	
        for(i = 0; i < N; i++) {
            poly_strings[i] = (char *)malloc(2000*sizeof(char));
            fgets(poly_strings[i], 2000, fp);
            printf("%d. %s", i + 1, poly_strings[i]);
	}
	
        fclose(fp);

	while(1) {
            printf("\n\nWhat operation would you like to perform?\n1. ADD Two Polynomials\n2. MULTIPLY Two Polynomials\n3. Evaluate A Polynomial\n4. Exit Program\n\nEnter choice: ");
            scanf("%d", &choice);
            while(getchar() != '\n');
            printf("\n");

            switch(choice) {
		case 1: printf("\nEnter the polynomials that you would like to work with: ");
                    scanf("%d,%d", &n1, &n2);
                    while(getchar() != '\n');
                    if((n1<1) || (n1>N) || (n2<1) || (n2>N)) {
                        printf("Invalid Input. Start Again\n");
			continue;
                    }
		
                    strcpy(str_temp, poly_strings[n1-1]);
                    poly1->CreateList(str_temp);
                    strcpy(str_temp, poly_strings[n2-1]);
                    poly2->CreateList(str_temp);

                    sum->addPoly(poly2);
                    printf("\nThe symbolic sum of the 2 polynomials is:\n");
                    printPoly(sum);
                    poly1->freePoly();
                    poly2->freePoly();
                    sum->freePoly();
                    printf("\n");
                    break;
		case 2: printf("\nEnter the polynomials that you would like to work with: ");
                    scanf("%d,%d", &n1, &n2);
                    while(getchar() != '\n');
                    if((n1<1) || (n1>N) || (n2<1) || (n2>N)) {
                        printf("\nInvalid Input. Start Again\n");
			continue;
                    }
		
                    strcpy(str_temp, poly_strings[n1-1]);
                    poly1->CreateList(str_temp);
                    strcpy(str_temp, poly_strings[n2-1]);
                    poly2->CreateList(str_temp);
                    product->multiplyPoly();
                    printf("\nThe Symbolic Product of the 2 polynomials is:\n");
                    product->printPoly();
                    poly1->freePoly();
                    poly2->freePoly();
                    product->freePoly();
                    printf("\n");
                    break;
		case 3: printf("\nEnter the polynomial that you would like to work with: ");
                    scanf("%d", &n1);
                    while(getchar() != '\n');
                    if((n1<1) || (n1>N)) {
                        printf("\nInvalid Input. Start again\n");
			continue;
                    }
		
                    strcpy(str_temp, poly_strings[n1-1]);
                    poly1->CreateList(str_temp);

                    printf("\nEnter the evaluation point (the value of x): ");
                    scanf("%lf", &xvalue);
                    while(getchar() != '\n');
                    polyValue->evalPoly(xvalue);
                    printf("\nValue of that polynomial at %g is: %g\n",xvalue,polyValue);
                    poly1->freePoly();
                    printf("\n");
                    break;
		case 4: exit(1);
		default: printf("\nInvalid Choice! Please Try Again.\n");
                    continue;
            }

            printf("\nDo you wish to perform additional operations on the existing file (Y/N)? ");
            do {
                scanf("%c", &ch);
		while(getchar() != '\n');
                    if((ch=='Y') || (ch=='y') || (ch=='N') || (ch=='n'))
                        break;
                    else
                        printf("Invalid Input. Please Try Again: ");	
            } while(1);
		printf("\n");
		if((ch == 'n') || (ch == 'N'))
                    break;
	}

	for(i = 0; i < N; i++)
            free(poly_strings[i]);
        
        free(poly_strings);

	printf("Would you like to work with another file(Y/N)? ");
	do {
            scanf("%c", &ch);
            while(getchar() != '\n');
            if((ch == 'Y') || (ch == 'y') || (ch == 'N') || (ch == 'n'))
                break;
            else
		printf("Invalid Input. Please Try Again: ");
	} while(1);
            printf("\n");
            if((ch == 'n') || (ch == 'N'))
                break;
    }

    printf("\n\t\tThank you for choosing a product of P.Inc.\n\t\t\tPress any key to exit.\n");
    getchar();
    
    return 0;
}
