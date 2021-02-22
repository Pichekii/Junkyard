
package com.pichekiink.acmedistributors.responses;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The {@code CannedResponses} class returns the example XML files provided
 * with the assignment.
 */
public class CannedResponses {
    
    /**
     * Instantiates a {@code CannedResponses} object.
     */
    public CannedResponses() {
        
    }
    
    /**
     * Returns the contents of the <i>price-list-response.xml</i> XML file.
     * @return The contents of the <i>price-list-response.xml</i> XML file.
     */
    public String getPriceList() {
        final String resource = "price-list-response.xml";
        String response = null;
        
        try {
            response = this.getFileContents(resource);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(CannedResponses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }

    /**
     * Returns the contents of the <i>replenishment-response.xml</i> XML file.
     * @return The contents of the <i>replenishment-response.xml</i> XML file.
     */
    public String getReplenishment() {
        final String resource = "replenishment-response.xml";
        String response = null;
        
        try {
            response = this.getFileContents(resource);
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(CannedResponses.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    /**
     * Returns the contents of the specified file.
     * @param file The file to parse.
     * @return A string containing the contents of the file.
     * @throws URISyntaxException
     * @throws IOException 
     */
    private String getFileContents(String file) throws URISyntaxException, IOException {
        String response = "";
        
        Path path = Paths.get(this.getClass().getResource(file).toURI());
        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        
        String line = null;
        while((line = reader.readLine()) != null) {
            response = response + line.trim();
        }
        
        return response;
    }
}
