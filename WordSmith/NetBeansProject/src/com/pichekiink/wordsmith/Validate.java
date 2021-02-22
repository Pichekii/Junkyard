
package com.pichekiink.wordsmith;

/**
 * The {@code Validate} class checks the CLI argument(s) to ensure that the
 * input adheres to the input restrictions: only one argument, the word is
 * 25 characters in length or less, and the word is only composed of
 * alphabetical letters.
 * 
 * @author Scott Natelli
 */
public class Validate {
    
    /**
     * @param LENGTH_LIMIT          The maximum number of letters in the word.
     * @param VALID_CHARACTERS      The valid characters to make up a word.
     * @param WITH_SERIOUS_ISSUES   Exit code if an error occurs.
     */
    private static final int LENGTH_LIMIT = 25;
    private static final String VALID_CHARACTERS = "[a-zA-Z]*";
    private static final int WITH_SERIOUS_ISSUES = 1;
    
    /**
     * Constructs a {@code Validate} object.
     */
    public Validate() {
        
    }
    
    /**
     * Checks to see if the word contains only alphabetically characters.
     * 
     * @param word The user defined word.
     */
    public void characters(String word) {
        if (!word.matches(VALID_CHARACTERS)) {
            System.out.println("Not a valid word; can only contain alphabetical characters.");
            System.exit(WITH_SERIOUS_ISSUES);
        }
    }
    
    /**
     * Validates the CLI arguments are no greater than 1.
     * 
     * @param args The CLI arguments.
     */
    public void cliArgumentsLength(String[] args) {
        if (args.length != 1) {
            System.out.println("The program requires ONE argument in order to run.");
            System.exit(WITH_SERIOUS_ISSUES);
        }
    }
    
    /**
     * Validates that the word is no longer than 25 characters in length.
     * 
     * @param word The user defined word.
     */
    public void wordLength(String word) {
        if (word.length() > LENGTH_LIMIT) {
            System.out.println("Word length is too long; a maximum of 25 characters is allowed.");
            System.exit(WITH_SERIOUS_ISSUES);
        }
    }
}
