
package com.pichekiink.trivia.rest;

/**
 * The {@code WhoIsAPI} enum contains the resource endpoints for the <i>WhoIs</i> REST API.
 * <p>
 * The documentation for the API can be found at the following link:
 *         https://www.arin.net/resources/whoisrws/whois_api.html#whoisrws
 * 
 * @author Scott Natelli
 */
public enum WhoIsAPI {
    
    ASN_RESOURCE("asn"),
    CUSTOMER_RESOURCE("customer"),
    ORGANIZATION_RESOURCE("org"),
    POINT_OF_CONTACT_RESOURCE("poc"),
    RDNS_RESOURCE("rdns");
    
    /**
     * @var resource The resource endpoint for the API.
     */
    private final String resource;
    
    /**
     * Instantiates a {@code WhoIsAPI} object with a resource endpoint.
     * @param resource 
     */
    private WhoIsAPI(String resource) {
        this.resource = resource;
    }
    
    /**
     * Returns the resource endpoint.
     * @return The resource endpoint.
     */
    @Override
    public String toString() {
        return this.resource;
    }
}
