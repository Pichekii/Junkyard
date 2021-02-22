
package com.pichekiink.wordsmith;

/**
 * The {@code Letter} class contains the alphabetical value of a letter in
 * relation to the word, and the number of times that letter occurs in the word.
 */
public class Letter {
    
    /**
     * @param occurrence        The number of times the letter occurs.
     * @param alphabeticalValue The alphabetical value of the letter.
     */
    private int occurrence;
    private int alphabeticalValue;
    
    public Letter() {
        this.occurrence = 0;
        this.alphabeticalValue = 0;
    }
    
    /**
     * Returns the occurrence of the letter.
     * 
     * @return An integer representing the number of occurrences.
     */
    public int getOccurence() {
        return this.occurrence;
    }
    
    /**
     * Returns the alphabetical value of the letter.
     * 
     * @return An integer representing the alphabetical value of the letter.
     */
    public int getAlphabeticalValue() {
        return this.alphabeticalValue;
    }
    
    /**
     * Sets the alphabetical value of the letter.
     * 
     * @param alphabeticalValue Integer representing the alphabetical value of the letter.
     */
    public void setAlphabeticalValue(int alphabeticalValue) {
        this.alphabeticalValue = alphabeticalValue;
    }
    
    /**
     * Increments the occurrence of the letter.
     */
    public void incrementOccurence() {
        this.occurrence++;
    }
    
    /**
     * Decrements the occurrence of the letter.
     */
    public void decrementOccurence() {
        this.occurrence--;
    }
}
