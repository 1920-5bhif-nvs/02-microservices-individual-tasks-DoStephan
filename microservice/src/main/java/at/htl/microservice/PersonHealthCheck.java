package at.htl.microservice;

import org.eclipse.microprofile.health.*;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Readiness
@ApplicationScoped
public class PersonHealthCheck implements HealthCheck {

    @Inject
    @RestClient
    PersonService service;

    @Override
    public HealthCheckResponse call(){
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Database connection health check");

        try {
            service.getAllPersonList();
            responseBuilder.up();
        }catch (Exception ex){
            responseBuilder.down();
        }

        return responseBuilder.build();
    }
}
