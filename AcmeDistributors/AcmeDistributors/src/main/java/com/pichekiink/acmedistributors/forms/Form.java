
package com.pichekiink.acmedistributors.forms;

/**
 * The {@code Form} interface provides the methods for creating the form objects
 * and processing any form requests.
 */
public interface Form {
    
    /**
     * Returns a {@code Form} object.
     * @return A {@code Form} object.
     */
    public abstract Form getInstance();
    
    /**
     * Returns the appropriate response for the form request.
     * @param data The data in the form request.
     * @return A response to the form request.
     */
    public abstract String process(String data);
}
