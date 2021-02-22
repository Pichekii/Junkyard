
package com.pichekiink.targetpractice.cli;

import java.util.Arrays;
import java.util.List;

/**
 * The {@code VerifyArguments} class parses the CLI arguments passed to the
 * applications, and sets the paths for the input files.
 */
public class VerifyArguments {
    
    /**
     * Instantiates a {@code VerifyArguments} object.
     */
    public VerifyArguments() {
        
    }
    
    /**
     * Parses the CLI arguments for the files used as the input sources.
     * @param args The CLI arguments.
     * @return An {2code InputFiles} object.
     */
    public InputFiles parseParameters(String[] args) {
        InputFiles inputFiles = new InputFiles();
        List<String> cliArguments= Arrays.asList(args);
        
        for(int index = 0; index < cliArguments.size(); index++) {
            Flags flag = this.getFlag(cliArguments.get(index));
            
            switch(flag) {
                case SHOTS_FIRED_FILE:
                    index++;
                    inputFiles.setShotsFired(cliArguments.get(index));
                    break;
                case TARGETS_FILE:
                    index++;
                    inputFiles.setTargets(cliArguments.get(index));
                    break;
                default:
                    System.out.println("Invalid CLI flag or argument.");
                    break;
            }
        }
        
        return inputFiles;
    }
    
    /**
     * Maps the CLI argument to the respective {@code Flags} enum constant.
     * @param argument The CLI argument passed to the application.
     * @return A {@code Flags} constant representing the CLI argument.
     */
    private Flags getFlag(String argument) {
        Flags flag = null;
        
        for(Flags temp : Flags.values()) {
            if(argument.equals(temp.toString())) {
                flag = temp;
                break;
            }
        }
        
        return flag;
    }
}
