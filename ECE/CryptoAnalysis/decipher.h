#define NAME_LEN 80
#define KEY_SIZE 26
#define MAX_SIZE 5001

char load_files(char key_file[], char text_file[], char cipher_key[], char message[]);
void decrypt(char output[], char cipher_key[], char message[]);
void encrypt(char outpout[], char cipher_key[], char message[]);
void output_message(char output[], char message[]);
