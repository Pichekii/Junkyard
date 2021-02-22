
package com.pichekiink.trivia.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * The {@code WhoIsRestClient} class queries the <i>WhoIs</i> REST API.
 * 
 * @author Scott Natelli
 */
public class WhoIsRestClient {
    
    /**
     * @var client The HTTP client object for connecting to the API.
     * @var response The object that represents the response from the API.
     * @var uri The base URI for the REST API.
     */
    private Client client;
    private Response response;
    private String uri;
    
    /**
     * Instantiates a {@code WhoIsRestClient} object with a base URI for the API.
     * @param uri The base URI for the REST API.
     */
    public WhoIsRestClient(String uri) {
        this.client = ClientBuilder.newClient();
        this.uri = uri;
    }
    
    /**
     * Returns the HTTP response code from the resource.
     * @return The HTTP response code from the resource.
     */
    public int getResponseCode() {
        return this.response.getStatus();
    }
    
    /**
     * Returns the response from the resource as a {@code String}.
     * @return The response from the resource.
     */
    public String getResponseOutput() {
        return this.response.readEntity(String.class);
    }
    
    /**
     * Queries the specified resource endpoint for the specified UID.
     * @param resource The resource endpoint to hit.
     * @param uid The UID to search for.
     * @param dataFormat The data format for the response.
     */
    public void getResource(WhoIsAPI resource, String uid, String dataFormat) {
        WebTarget webTarget = this.buildResourceURI(resource, uid, dataFormat);
        Invocation.Builder invocationBuilder = webTarget.request();
        this.response = invocationBuilder.get();
    }
    
    /**
     * Builds the {@code WebTarget} object (i.e. the URL) for the API.
     * @param resource The resource endpoint to hit.
     * @param uid The UID to search for.
     * @param dataFormat The data format for the response.
     * @return A {@code WebTarget} object for the resource to hit.
     */
    private WebTarget buildResourceURI(WhoIsAPI resource, String uid, String dataFormat) {
        String completeUID = null;
        
        if(dataFormat == null) {
            completeUID = uid;
        } else {
            completeUID = uid.concat(".").concat(dataFormat);
        }
        
        WebTarget webTarget = this.client.target(this.uri)
                .path(resource.toString())
                .path(completeUID);
        
        return webTarget;
    }
}
