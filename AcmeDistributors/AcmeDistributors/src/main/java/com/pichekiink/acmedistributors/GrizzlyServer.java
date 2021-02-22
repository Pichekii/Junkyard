package com.pichekiink.acmedistributors;

import com.pichekiink.acmedistributors.registration.FormRegistration;
import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * The {@code GrizzlyServer} class starts a Grizzly server that hosts the REST
 * resources found in the {@link com.pichekiink.acmedistributors.resources} package.
 * <br /><br />
 * This class is based on the <i>jersey-quickstart-grizzly2</i> Maven example project. More
 * information can be found at the following <a href="https://jersey.java.net/documentation/latest/getting-started.html">link</a>.
 */
public class GrizzlyServer {

    /**
     * @var BASE_URI The base URI for the REST resources.
     * @var RESOURCES_PACKAGE The package containing the REST resources to expose.
     */
    public static final String BASE_URI = "http://localhost:8282/acmedistributors/";
    private static final String RESOURCES_PACKAGE = "com.pichekiink.acmedistributors.resources";
    

    /**
     * Starts the Grizzly server.
     * @param args The CLI arguments to the application.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        registerForms();
        final HttpServer server = startServer();
        System.out.println("The server has been started with any avaiable REST resources found at: " + BASE_URI);
        System.out.println("Hit enter to stop the server.");
        System.in.read();
        server.shutdown();
    }

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return A Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        registerForms();
        final ResourceConfig rc = new ResourceConfig().packages(RESOURCES_PACKAGE);
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }
    
    /**
     * Registers the available forms for the web application.
     */
    private static void registerForms() {
        FormRegistration formRegistration = new FormRegistration();
        formRegistration.process();
    }
}
