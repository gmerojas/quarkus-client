package org.acme.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.response.HandlerResponse;
import org.acme.service.ShowService;

@Path("api/tvmaze")
public class ShowController {

    @Inject
    private ShowService service;

    @GET
    @Path("shows/{showId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShow(@PathParam("showId") Integer showId){
        HandlerResponse handlerResponse = service.getShowsById(showId);
        return Response.status(handlerResponse.getMetadata().getHttpCode()).entity(handlerResponse).build();
    }

}
