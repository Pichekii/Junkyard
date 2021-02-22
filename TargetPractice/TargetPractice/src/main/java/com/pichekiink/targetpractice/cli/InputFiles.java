
package com.pichekiink.targetpractice.cli;

/**
 * The {@code InputFiles} class contains the paths for the files whose contents
 * consist of the point coordinates for the two targets and the shots fired.
 */
public class InputFiles {
    
    private String shotsFiredFile;
    private String targetsFile;
    
    /**
     * Instantiates a {@code InputFiles} object.
     */
    public InputFiles() {
        
    }
    
    /**
     * Returns the path to the file containing the point coordinates for shots fired.
     * @return The path to the file containing the point coordinates.
     */
    public String getShotsFired() {
        return this.shotsFiredFile;
    }
    
    /**
     * Returns the path to the file containing the point coordinates for the targets.
     * @return The path to the file containing the point coordinates.
     */
    public String getTargets() {
        return this.targetsFile;
    }
    
    /**
     * Sets the path to the file containing the point coordinates for shots fired.
     * @param file The path to the file containing the point coordinates.
     */
    public void setShotsFired(String file) {
        this.shotsFiredFile = file;
    }
    
    /**
     * Sets the path to the file containing the point coordinates for the targets.
     * @param file The path to the file containing the point coordinates.
     */
    public void setTargets(String file) {
        this.targetsFile = file;
    }
}
