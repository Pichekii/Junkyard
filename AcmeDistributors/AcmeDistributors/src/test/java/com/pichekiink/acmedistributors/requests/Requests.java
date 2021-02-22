
package com.pichekiink.acmedistributors.requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The {@code Requests} enum returns the contents of the example XML requests.
 */
public enum Requests {
    
    PRICE_LIST("price-list-request.xml"),
    REPLENISHMENT("replenishment-request.xml");
    
    /**
     * @var resource The resource file.
     */
    private final String resource;
    
    /**
     * Instantiates a {@code Requests} object provided a resource file.
     * @param resource The resource file.
     */
    private Requests(String resource) {
        this.resource = resource;
    }
    
    /**
     * Returns the contents of the resource file.
     * @return The contents of the resource file.
     * @throws IOException
     * @throws URISyntaxException 
     */
    public String getRequest() throws IOException, URISyntaxException {
        String request = "";
        Path path = Paths.get(this.getClass().getResource(this.resource).toURI());
        BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        
        String line = null;
        while((line = reader.readLine()) != null) {
            request = request + line.trim();
        }
        
        return request;
    }
}
