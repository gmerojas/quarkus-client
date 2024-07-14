package org.acme.contract.restclient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.Show;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@RegisterRestClient//(baseUri = "https://api.tvmaze.com")
public interface IShowRestClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/shows/{showId}")
    Show getShowById(@PathParam("showId") Integer showId);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/shows")
    List<Show> getShows();
}
