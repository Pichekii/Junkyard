/**
 * Scott Natelli
 * Assignment #2 - EE 312 Bank
 */

#include <stdio.h>
#include <math.h>

int main(void) {
    int index = 0;
    float principal, term, prepay, payment, month = 1, emi = 0;

    while( index != 3 ) {
        printf( "Good Morning! Welcome to the EE312 Bank. Please select from the\nfollowing choices:\n"
                "Press (1) to calculate the EMI for a new loan.\n"
                "Press (2) to calculate payment amounts for prepaying a loan.\n"
                "Press (3) to exit.\n" );
        scanf( "%d", &index );
	
        switch(index) {
            case 1:
                printf( "\nEnter the loan's principal amount: $" );
                scanf( "%f", &principal );
		printf( "Enter the loan's term (in months): " );
		scanf( "%f", &term );
		printf( "Thank you. Your estimated monthly payment (EMI) for each month\nis: $%.2f\n\n\n", (principal + (principal * .2))/term );
		break;
            case 2:
                printf( "\nEnter the loan's remaining principal: $" );
		scanf( "%f", &principal );
		printf( "Enter the number of months remaining on the loan's term: " );
		scanf( "%f", &term );
		printf( "Enter the intended percentage of prepayment: " );
		scanf( "%f", &prepay );
		printf( "Thank you. Here are your calculated payment amounts and the\nbalance at the end of each month:\n" );
		printf(	"month\t\tPayment Amount\t\tRemaining Balance\n" );
		principal *= 1.2;
                
                while (month <= term) {
                    if ( emi < principal ) {
                        emi = principal/(term - month + 1);
			payment = emi + emi * (prepay/100);
                    } else payment = principal;
                
                    principal = principal - payment;
                    printf( "%.0f\t\t%.2f\t\t%.2f\n", month, payment, principal);
                    month++;
                }
		
                printf( "\n\n" );
		break;
            case 3:
		printf( "\nThank you for choosing EE312 Banking services, and have a nice day!" );
		getch();
		break;
            default:
		printf( "\nInvalid character! Please select (1), (2), or (3).\n\n" );
		break;
	}
    }
    
    return 0;
}
