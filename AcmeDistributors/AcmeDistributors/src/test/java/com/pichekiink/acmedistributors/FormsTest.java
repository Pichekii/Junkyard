
package com.pichekiink.acmedistributors;

import com.pichekiink.acmedistributors.GrizzlyServer;
import com.pichekiink.acmedistributors.requests.Requests;
import com.pichekiink.acmedistributors.responses.Responses;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import org.glassfish.grizzly.http.server.HttpServer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

/**
 * The {@code FormTest} class submits example form requests to the valid
 * {@link com.pichekiink.acmedistributors.resources.FormRequest} REST resource,
 * and validates the response with the expected information.
 */
public class FormsTest {
    
    /**
     * @var FORM_RESOURCE The REST resource endpoint to hit.
     * @var QUERY_PARAMETER The key for the query parameter.
     */
    final String FORM_RESOURCE = "requests";
    final String QUERY_PARAMETER = "content";
    
    /**
     * @var server The Grizzly server.
     * @var webTarget The {@code WebTarget} object to hit the REST resource(s).
     */
    private HttpServer server;
    private WebTarget webTarget;
    
    /**
     * Sets up any test resources; starts a Grizzly server and creates a
     * {@link WebTarget} object for accessing the REST URI(s).
     * @throws Exception 
     */
    @BeforeClass
    public void setUpClass() throws Exception {
        this.server = GrizzlyServer.startServer();
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target(GrizzlyServer.BASE_URI);
    }
    
    /**
     * Tears down any test resources; stops the Grizzly server.
     * @throws Exception 
     */
    @AfterClass
    public void tearDownClass() throws Exception {
        this.server.shutdown();
    }
    
    /**
     * Verifies that submitting a <i>price list</i> form to the {@link FormRequest}
     * resource successfully returns a valid price list form response.
     * @throws IOException
     * @throws URISyntaxException 
     */
    @Test
    public void getPriceList() throws IOException, URISyntaxException {
        final String formRequest = Requests.PRICE_LIST.getRequest();
        final String expectedResults = Responses.PRICE_LIST.getResponse();
        final String actualResults = this.performRequest("PriceListForm", formRequest);
        
        assertEquals(actualResults, expectedResults);
    }
    
    /**
     * Verifies that submitting a <i>replenishment</i> form to the {@link FormRequest}
     * resource successfully returns a valid replenishment form response.
     * @throws IOException
     * @throws URISyntaxException 
     */
    @Test
    public void getReplenishmentStatus() throws IOException, URISyntaxException {
        final String formRequest = Requests.REPLENISHMENT.getRequest();
        final String expectedResults = Responses.REPLENISHMENT.getResponse();
        final String actualResults = this.performRequest("ReplenishmentForm", formRequest);
        
        assertEquals(actualResults, expectedResults);
    }
    
    /**
     * Returns the response for the submitted form request.
     * @param formType The type of form being submitted.
     * @param formContent The content of the form being submitted.
     * @return The response from the REST resource.
     */
    private String performRequest(String formType, String formContent) {
        return this.webTarget.path(this.FORM_RESOURCE).path(formType).queryParam(this.QUERY_PARAMETER, formContent).request().get(String.class);
    }
}
