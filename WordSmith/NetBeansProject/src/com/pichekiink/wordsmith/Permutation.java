
package com.pichekiink.wordsmith;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * The {@code Permutation} class determines the alphabetical rank of a word
 * based on the permutation of the letters.
 * 
 * @author Scott Natelli
 */
public class Permutation {
    
    /**
     * @param word              The user defined word.
     * @param sortedWord        The word sorted alphabetically.
     * @param letterComposition Contains a {@code Letter} object for each
     *                          different letter in the word.
     */
    private String word;
    private String sortedWord;
    private LinkedHashMap<String, Letter> letterComposition;
    
    /**
     * Constructs a {@code Permutation} object consisting of the word, the
     * sorted version of the word, and the different letters that compose the word.
     * 
     * @param word The user defined word.
     */
    public Permutation(String word) {
        this.word = word;
        this.letterComposition = new LinkedHashMap<>(this.word.length());
        
        char[] temp = this.word.toCharArray();
        Arrays.sort(temp);
        this.sortedWord = new String(temp);
    }
    
    /**
     * Calculates the occurrence and alphabetical value of each letter in the word.
     */
    public void letterOccurenceAndValue() {
        
        int alphabeticalValue = 1;
        
        for (int index = 0; index < this.sortedWord.length(); index++) {
            String character = String.valueOf(this.sortedWord.charAt(index));
            
            /**
             * Calculates the occurrence of the letter.
             */
            if (this.letterComposition.get(character) == null) {
                Letter letter = new Letter();
                letter.incrementOccurence();
                this.letterComposition.put(character, letter);
            } else {
                this.letterComposition.get(character).incrementOccurence();
            }
            
            /**
             * Calculates the alphabetical value of the letter.
             */
            if (index == 0) {
                this.letterComposition.get(character).setAlphabeticalValue(alphabeticalValue);
            } else {
                String previousLetter = String.valueOf(this.sortedWord.charAt(index - 1));
                if (!character.equals(previousLetter)) {
                    alphabeticalValue++;
                    this.letterComposition.get(character).setAlphabeticalValue(alphabeticalValue);
                }
            }
        }
    }
    
    /**
     * Calculates the alphabetical rank of the word.
     * 
     * @return A double value representing the alphabetical rank of the word.
     */
    public double rank() {
        double wordRank = 0;     
        
        for (int index = 0; index < this.word.length(); index++) {
            
            /**
             * @param value         The number of letters the current letter is alphabetically greater than.
             * @param denominator   The product of the factorial of each letter's occurrence.
             */
            double value = 0;
            double denominator = 1;
            
            String leadingcharacter = String.valueOf(this.word.charAt(index));
            int leadingCharacterValue = this.letterComposition.get(leadingcharacter).getAlphabeticalValue();
            
            /**
             * Calculates the {@code value} of the current letter in the word.
             */
            for (int indexOfSubword = index + 1; indexOfSubword < this.word.length(); indexOfSubword++) {
                String trailingCharacter = String.valueOf(this.word.charAt(indexOfSubword));
                int trailingcharacterValue = this.letterComposition.get(trailingCharacter).getAlphabeticalValue();
                
                if (leadingCharacterValue > trailingcharacterValue) {
                    value++;
                }
            }
            
            Set<String> keySet = this.letterComposition.keySet();
            Iterator<String> iterator = keySet.iterator();
            
            /**
             * Calculates the {@code denominator} of the current letter in the word.
             */
            while (iterator.hasNext()) {
                String character = iterator.next().toString();
                denominator = denominator * factorial(this.letterComposition.get(character).getOccurence());
            }
            
            double remainingLetters = factorial(this.word.length() - (index + 1));
            wordRank = (wordRank + ((value / denominator) * remainingLetters));
            
            this.letterComposition.get(leadingcharacter).decrementOccurence();
        }
        
        wordRank = wordRank + 1;        
        return wordRank;
    }
    
    /**
     * Calculates the factorial of an integer alphabeticalValue.
     * 
     * @param alphabeticalValue The integer alphabeticalValue.
     * @return The factorial of the integer argument.
     */
    private double factorial(int value) {
        
        double factorial = 1;
        
        while (value > 1) {
            factorial = factorial * value;
            value--;
        }
        
        return factorial;
    }
}
