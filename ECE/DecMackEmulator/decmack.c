/**
 * Scott Natelli
 * Assignment 4 - DecMack Emulator
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define File interpreter.txt

void execute_instructions(int RAM[]);
void output(int inst_count[]);
int execute(int inst_type, int operand_one, int operand_two, int RAM[], int REG[]);


int main(int argc, char *argv[]) {
    FILE *fp;
    char s[5] = {0};
    int value, num_prog, pointer = 0, RAM[1000] = {0};

    fp = fopen("interpreter.txt", "r+");
    if (fp == NULL) {
        printf("\n\t\tERROR! File interpreter.txt Does Not Exist!\n\n");
        printf("\t\t\tPress any key to exit.");
        getchar ();
        exit(1);
    }
    
    /* Gets the first line which tells how many programs there are. */
    fgets(s, 5, fp);
    num_prog = atoi(s);
    
    /* Skips ove the new line seperating the number of programs and the first program. */
    fgets(s, 5, fp);

    /* Moves each "program into "RAM" until it encounters the a new line. Then executes, and repeats until all of the "programs" are executed. */
    while (num_prog--) {
        pointer = 0;
	while (fgets(s, 5, fp) && pointer < 1000) {
            if (!strcmp(s, "\n"))
                break;
            RAM[pointer] = atoi(s);
            pointer++;
	}
	
        execute_instructions(RAM);
	
        /* Restes the "memory" for the programs. Initializes them to 0. */
	for (pointer = 0; pointer < 1000; pointer++)
            RAM[pointer] = 0;
    }

    fclose(fp);
    return 0;
}


void execute_instructions(int RAM[]) {
    int inst_type, operand_one, operand_two, pointer;
    int inst_count[10] = {0}, REG[10] = {0};
    
    /* Checks for the end of the file. */
    for (pointer = 0; RAM[pointer] != EOF; pointer++) {
        /* If the instruction is less than 100 then the instruction 0(the value stored in the array is stored as 23 not 023). */
        if (RAM[pointer] < 100) {
            inst_type = 0;
            operand_one = RAM[pointer]/10;
            operand_two = RAM[pointer] - (operand_one*10);
	} else {
            /* If the instruction is not less than 100 then the instruction type is between 1 and 9. */
            inst_type = (RAM[pointer])/100;
             /* If the instruction type is 1 then it is a halt command. */
            if (inst_type == 1) {
                inst_count[inst_type] = inst_count[inst_type] + 1;
                output(inst_count);
                
                /* Resets the instruction counter back to 0. */
		for (pointer = 0; pointer < 10; pointer++)
                    inst_count[pointer] = 0;
		
                /* Resets the registers. */
		for (pointer = 0; pointer < 10; pointer++)
                    REG[pointer] = 0;
		break;
            }
            operand_one = (RAM[pointer] - (inst_type*100))/10;
            operand_two = RAM[pointer] - ((operand_one*10) + (inst_type*100));
        }
        
        inst_count[inst_type] = inst_count[inst_type] + 1;
        execute(inst_type, operand_one, operand_two, RAM, REG);
	
        /* This checks to see whether the instruction type is a goto instruction. If it is it will set the pointer to the jump location. */
        if (inst_type == 0) {
            if (REG[operand_two] != 0)
            pointer = REG[operand_one] - 1;
	}        
    }

    return;
}


void output(int inst_count[]) {
    int total_execute = 0, instruct;

    /* Totals up the different instructions. */
    for (instruct = 0; instruct < 10; instruct++)
        total_execute = total_execute + inst_count[instruct];
    
    printf("Output:\n%5d\n\n", total_execute);
    printf("     Frequency Table\n");
    printf("Instruction\t  Count\nType\n");
    printf("-----------\t  ------\n");
    
    /* Outputs the information for the table. */
    for (instruct = 0; instruct < 10; instruct++)
        printf("%d%19d\n", instruct, inst_count[instruct]);

    printf("\nPress any key to continue.\n");
    getchar ();
    return;
}


int execute(int inst_type, int operand_one, int operand_two, int RAM[], int REG[]) {
    switch (inst_type) {
        case 0:
            break;
        case 1:
            break;
        case 2:
            REG[operand_one] = operand_two;
            break;
        case 3:
            REG[operand_one] = (REG[operand_one] + operand_two)%1000;
            break;
        case 4:
            REG[operand_one] = (REG[operand_one]*operand_two)%1000;
            break;
        case 5:
            REG[operand_one] = REG[operand_two];
            break;
        case 6:
            REG[operand_one] = (REG[operand_one] + REG[operand_two])%1000;
            break;
        case 7:
            REG[operand_one] = (REG[operand_one]*REG[operand_two])%1000;
            break;
        case 8:
            REG[operand_one] = RAM[REG[operand_two]];
            break;
        case 9:
            RAM[REG[operand_two]] = REG[operand_one];
            break;
    }        

    return RAM, REG;
}
