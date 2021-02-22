
package com.pichekiink.javaeexample.beans;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Scott Natelli
 */
public class ListClass {
    
    private LinkedList<Integer> listOfInts;
    
    public ListClass() {
        initList();
    }
    
    private void initList() {
        this.listOfInts = new LinkedList<>();
        
        Random random = new Random();
        
        for(int index = 0; index < 10; index++) {
            this.listOfInts.add(random.nextInt(100));
        }
    }
    
    public LinkedList<Integer> getListOfInts() {
        return this.listOfInts;
    }
}
