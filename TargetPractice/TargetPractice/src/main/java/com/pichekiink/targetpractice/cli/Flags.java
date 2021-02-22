
package com.pichekiink.targetpractice.cli;

/**
 * The {@code Flags} enum contains the available CLI flags for the application.
 */
public enum Flags {
    
    SHOTS_FIRED_FILE("-s"),
    TARGETS_FILE("-t");
    
    private final String flag;
    
    /**
     * Instantiates a {@code Flags} object provided a CLI flag.
     * @param flag The CLI flag.
     */
    private Flags(String flag) {
        this.flag = flag;
    }
    
    /**
     * Returns the CLI flag for the application.
     * @return The CLI flag.
     */
    @Override
    public String toString() {
        return this.flag;
    }
}
