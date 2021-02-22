
package com.pichekiink.javaeexample.beans;

import java.util.HashMap;

/**
 *
 * @author Scott Natelli
 */
public class MapClass {
    
    private HashMap<String, String> mapOfStrings;
    
    public MapClass() {
        initMap();
    }
    
    private void initMap() {
        
    }
    
    public HashMap<String, String> getMapOfStrings() {
        return this.mapOfStrings;
    }
}
