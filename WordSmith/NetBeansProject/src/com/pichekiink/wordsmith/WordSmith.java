
package com.pichekiink.wordsmith;

import java.text.DecimalFormat;

/**
 * The {@code WordSmith} class solves the dictionary rank for a word provided
 * as a CLI argument. 
 * 
 * @author Scott Natelli
 */
public class WordSmith {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String word = args[0];
        
        /**
         * Check the restrictions against the input.
         */
        Validate validate = new Validate();
        validate.cliArgumentsLength(args);
        validate.wordLength(word);
        validate.characters(word);
        
        word = word.toUpperCase();
        
        Permutation permutation = new Permutation(word);
        permutation.letterOccurenceAndValue();
        double wordRank = permutation.rank();
        
        DecimalFormat formatRank = new DecimalFormat();
        formatRank.setMinimumFractionDigits(0);
        formatRank.setGroupingUsed(false);
        
        System.out.println(formatRank.format(wordRank));
    }
}
