
package com.pichekiink.acmedistributors.resources;

import com.pichekiink.acmedistributors.forms.Form;
import com.pichekiink.acmedistributors.forms.FormFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * The {@code FormRequest} class contains the REST resource for submitting a
 * valid form to the application for processing.
 */
@Path("/requests")
public class FormRequest {
    
    /**
     * @var formFactory A {@link FormFactory} object containing the valid forms.
     */
    private final FormFactory formFactory;
    
    /**
     * Instantiates a new {@code FormRequest} object.
     */
    public FormRequest() {
        this.formFactory = new FormFactory();
    }
    
    /**
     * Submits a form for processing; returns an appropriate response to the submitted request.
     * @param formType The type of form being submitted.
     * @param formContent The content of the form being submitted.
     * @return An appropriate response to the form that was submitted.
     */
    @GET @Path("/{formtype}")
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.TEXT_XML)
    public String recieveProducts(@PathParam("formtype")String formType, @QueryParam("content")String formContent) {
        Form form = this.formFactory.getInstance(formType);
        return form.process(formContent);
    }
}
