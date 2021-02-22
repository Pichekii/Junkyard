/**
 * Scott Natelli
 * Assignment 3 - Sieve of Eratosthenes
 */

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define X 32767

int sieve_algorithm (int B[]);
void print_sieve (int B[], short int n);
void consecutive_prime_differences (int B[], short int n);
void consecutive_prime_sums (int B[], short int n);

int main(void) {
    short int n; 
    int B[X] = {0}; 
    char response;
	
    do {
        printf("Enter an integer value (n) to compile a list of prime numbers\nup until (n): ");
	scanf("%hd", &n);
	sieve_algorithm (B);
	print_sieve (B, n);
	consecutive_prime_differences (B, n);
	consecutive_prime_sums (B, n);
	printf("\n\n");
	printf("Would you like to compile another list of primes? (Y) or (N): ");
	response = getch ();
	printf("\n\n\n");
    } while (response == 'Y');

    return 0;
}
	

int sieve_algorithm (int B[]) {
    int pointer_A, pointer_B, multiple;
    int A[X] = {0};
	
    /*Copies numbers 2-32767 into array A*/
    for (pointer_A = 2, pointer_B = 0; pointer_B < X; pointer_A++, pointer_B++)
        A[pointer_B] = pointer_A;

	/*Flags non-primes*/
	for (pointer_A = 2; pointer_A < X; pointer_A++) {
            for (multiple = 2; multiple < 10; multiple++) {
                if ((pointer_A*multiple) < X)
                    A[(pointer_A*multiple-2)] = 0;
            }
	}

	/*Copies all primes into array B*/
	pointer_B = 0;
	for (pointer_A = 0; pointer_A < X; pointer_A++) {
            if (A[pointer_A]!=0) {
                B[pointer_B] = A[pointer_A];
		pointer_B++;
            }
	}

    return B;
}


void print_sieve (int B[], short int n) {
    int pointer, rows, columns, total_rows, gate_keeper;
    int num_rows = (n / 8);
    int partial_rows = (n % 8);

    if(partial_rows != 0)
        total_rows = num_rows + 1;
    else 
	total_rows = num_rows;

    if(total_rows == 1) {
        for(pointer = 0; pointer < n; pointer++)
	printf("%10d", B[pointer]);
    } else {
        for(rows = 0; rows < total_rows; rows++) {
            pointer = rows;
	
            if(rows != (total_rows - 1)) {
                for(columns = 0; columns < 8; columns++) {
                    printf("%10d", B[pointer]);
                    
                    if(columns < partial_rows)
			pointer = pointer + total_rows;
                    else 
			pointer = pointer + num_rows;
		}
		printf("\n");
            } else {
                for(columns = 0; columns < 8; columns++) {
                    printf("%10d", B[pointer]);
                    pointer = pointer + total_rows;
		}
            }
	}
    }		

    printf("\n");

    if (n > X)
        printf("A further list of prime numbers cannot be generated, because n exceeds the capacity of the system.");

    return;
}

/**
 * Takes the next element of the array, and subtracts the previous element;
 * checks to see if they have a difference of 4.
 */
void consecutive_prime_differences (int B[], short int n) {
    int prime_one, prime_two;

    printf("\n");
    
    for (prime_one = 0, prime_two = 1; prime_two < n; prime_one++, prime_two++) {
        if ((B[prime_two] - B[prime_one]) == 4)
            printf("The pair of primes %d, %d has a difference of 4.\n", B[prime_one], B[prime_two]);
    }

    return;
}

/**
 * Takes three consecutive primes; sums them and checks to see if the sum is a prime number.
 */
void consecutive_prime_sums (int B[], short int n) {
    int pointer, sum, prime_one, prime_two, prime_three;

    printf("\n");

    for (prime_one = 0, prime_two = 1, prime_three = 2; prime_three < n; prime_one++, prime_two++, prime_three++) {
        sum = B[prime_one] + B[prime_two] + B[prime_three];
	
        for (pointer = 0; pointer < n; pointer++) {
            if (sum == B[pointer])	
            printf("%d + %d + %d = %d (Which is a CPSP of order-3)\n", B[prime_one], B[prime_two], B[prime_three], sum);
	}
    }

    return;
}
