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
    @Path("shows-1/{showId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowsById1(@PathParam("showId") Integer showId){
        HandlerResponse handlerResponse = service.getShowsById1(showId);
        return Response.status(handlerResponse.getMetadata().getHttpCode()).entity(handlerResponse).build();
    }

    @GET
    @Path("shows-1")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShows1(){
        HandlerResponse handlerResponse = service.getShows1();
        return Response.status(handlerResponse.getMetadata().getHttpCode()).entity(handlerResponse).build();
    }

    @GET
    @Path("shows-2")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShows2(){
        HandlerResponse handlerResponse = service.getShows2();
        return Response.status(handlerResponse.getMetadata().getHttpCode()).entity(handlerResponse).build();
    }

    @GET
    @Path("shows-2/{showId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getShowsById2(@PathParam("showId") Integer showId){
        HandlerResponse handlerResponse = service.getShowsById2(showId);
        return Response.status(handlerResponse.getMetadata().getHttpCode()).entity(handlerResponse).build();
    }
}
