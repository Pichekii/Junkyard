
package com.pichekiink.trivia.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * The {@code WhoIsRestClientTest} class verifies that the {@link WhoIsRestClient} class
 * successfully connects to and retrieves a response from the <i>WhoIs</i> REST API.
 * <p>
 * More information about the WhoIs REST API can be found at the following link:
 *         https://www.arin.net/resources/whoisrws/whois_api.html
 * 
 * @author Scott Natelli
 */
public class WhoIsRestClientTest {
    
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    
    /**
     * @var whoIsURI The base URI for the <i>WhoIs</i> REST API.
     */
    private final String whoIsURI = "http://whois.arin.net/rest";
    
    /**
     * Sets up any resources before executing the tests.
     */
    @BeforeClass
    public void setUp() {
        this.LOG.info("Beginning tests in: {}", this.getClass());
    }
    
    /**
     * Clean up any resources used by the tests.
     */
    @AfterClass
    public void tearDown() {
        this.LOG.info("Finished all tests in: {}", this.getClass());
    }
    
    /**
     * Verifies that the {@link WhoIsRestClient#getResource} method successfully queries for an organization entity.
     * @param uri The URI for the REST API.
     * @param resource The resource endpoint to hit.
     * @param organization The name of the organization to look up.
     * @param dataFormat The data format to return the results in.
     */
    @Test(dataProvider = "organizationalParameters")
    public void lookupOrganization(String uri, WhoIsAPI resource, String organization, String dataFormat) {
        WhoIsRestClient restClient = new WhoIsRestClient(uri);
        restClient.getResource(resource, organization, dataFormat);
        
        this.LOG.info("The HTTP response code is: {}", restClient.getResponseCode());
        this.LOG.info("The response output is: {}", restClient.getResponseOutput());
    }
    
    /**
     * Generates the input parameter for the {@link #lookupOrganization} method.
     * @return The input parameters for the {@link #lookupOrganization} method.
     */
    @DataProvider
    public Object[][] organizationalParameters() {
        return new Object[][] {
            {this.whoIsURI, WhoIsAPI.ORGANIZATION_RESOURCE, "RAYTH-25", "txt"}
        };
    }
}
