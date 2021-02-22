
package com.pichekiink.characterpyramid;

/**
 * The {@code CharacterPyramid} class accepts two command line arguments, a
 * single character and an integer value, which it uses to print a pyramid
 * consisting of the provided character and at the specified height.
 * 
 * @author Scott Natelli
 */
public class CharacterPyramid {
    
    /**
     * Outputs a pyramid to STDOUT at the specified height and consisting of
     * the specified character.
     * @param args The command line arguments for the program.
     */
    public static void main(String[] args) {
        
        validateParameters(args);
        
        String character = args[0];
        int height = Integer.valueOf(args[1]);
        
        outputPyramid(character, height);
    }
    
    /**
     * Validates that the user has provided two arguments to the program.
     * @param args The command line arguments provided to the program.
     */
    private static void validateParameters(String[] args) {
        
        if(args.length != 2) {
            System.out.println("Invalid arguments!");
            System.out.println("The program requires a valid character and an integer value between 1 - 20.");
            System.exit(1);
        }        
    }
    
    /**
     * Outputs the rows of the pyramid to STDOUT.
     * @param character The character value the pyramid will be composed of.
     * @param height The height of the pyramid (i.e. number of rows).
     */
    private static void outputPyramid(String character, int height) {
        
        int rowIndentation = height - 1;
        int rowCharacterLength = 1;
        
        for(int index = 0; index < height; index++) {
            
            for(int spaceIndex = 0; spaceIndex < rowIndentation; spaceIndex++) {
                System.out.print(" ");
            }
            
            for(int valueIndex = 0; valueIndex < rowCharacterLength; valueIndex++) {
                System.out.print(character);
                
                if(valueIndex < rowCharacterLength - 1) {
                    System.out.print(" ");
                }
            }
            
            System.out.println();
            rowIndentation--;
            rowCharacterLength++;
        }
    }
}
