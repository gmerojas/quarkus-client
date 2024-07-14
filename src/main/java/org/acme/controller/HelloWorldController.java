package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.contract.service.HelloWorldServiceInterface;
import org.acme.response.HandlerResponse;

@Path("api")
public class HelloWorldController {

    @Inject
    private HelloWorldServiceInterface helloWorldService;

    @GET
    @Path("helloWorld")
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloWorld(){

        HandlerResponse handlerResponse = helloWorldService.helloWorld();

        return Response.status(Response.Status.OK).entity(handlerResponse).build();
    }

    @GET
    @Path("helloWorld/{languaje}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloWorld(@QueryParam("languaje") String language){

        HandlerResponse handlerResponse = helloWorldService.helloWorld(language);

        return Response.status(handlerResponse.getMetadata().getHttpCode()).entity(handlerResponse).build();
    }
}
