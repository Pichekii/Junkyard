
package com.pichekiink.javaeexample.beans;

/**
 *
 * @author Scott Natelli
 */
public class ArrayClass {
    
    private String[] arrayOfStrings;
    
    public ArrayClass() {
        initArray();
    }
    
    private void initArray() {
        this.arrayOfStrings = new String[12];
        
        int index = 0;
        for(char letter = 'A'; letter < 'M'; letter++) {
            this.arrayOfStrings[index] = String.valueOf(letter);
            index++;
        }
    }
    
    public String[] getArrayOfStrings() {
        return this.arrayOfStrings;
    }
}
