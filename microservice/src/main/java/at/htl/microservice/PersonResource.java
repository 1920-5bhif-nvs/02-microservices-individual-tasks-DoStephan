package at.htl.microservice;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.*;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonResource {
    @Inject
    @RestClient
    PersonService service;

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    @Retry(maxRetries = 4)
    @Counted(name = "requestAmount", description = "Amount of requests")
    @Timed(name = "responseTimer", description = "Repsonse time (milliseconds)", unit = MetricUnits.MILLISECONDS)
    @Fallback(fallbackMethod = "noPerson")
    public Response get() {
        return Response.ok().entity(service.getAllPersonList()).build();
    }

    public Response noPerson(){
        return Response.ok().entity(Json.createObjectBuilder().add("Message", "Fallback response").build()).build();
    }
}
