package org.acme.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import org.acme.contract.restclient.IShowRestClient;
import org.acme.contract.service.IShowService;
import org.acme.dto.Show;
import org.acme.response.HandlerResponse;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class ShowService implements IShowService {

//    private final ExecutorService executorService = Executors.newCachedThreadPool();
//    @Override
//    public HandlerResponse getShowsById(Integer showId) {
//
//        String message = "Success";
//        Integer httpCode = Response.Status.OK.getStatusCode();
//
//        HandlerResponse.MetadataResponse metadataResponse = new HandlerResponse.MetadataResponse();
//        HandlerResponse.DataResponse dataResponse = new HandlerResponse.DataResponse();
//
//        Show show = new Show();
//
//        try{
//
//            ClientBuilder builder = ClientBuilder.newBuilder();
//            Client client = builder.build();
//            WebTarget webTarget = client.target("https://api.tvmaze.com/shows/" + showId);
//            Response response = webTarget.request().get();
//
//            if(response.getStatus() == Response.Status.OK.getStatusCode()){
//                String entityResponse = response.readEntity(String.class);
//                System.out.println(entityResponse);
//                JsonObject jsonObject = new JsonObject(entityResponse);
//                ObjectMapper objectMapper = new ObjectMapper();
//                objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
//
//                show = objectMapper.readValue(jsonObject.encode(), new TypeReference<Show>() {});
//            }else{
//                message = "Error";
//                httpCode = Response.Status.NOT_FOUND.getStatusCode();
//            }
//
//        }catch (Exception ex){
//            System.out.println("Error al obtener listado de shows por ID. Message: " + ex.getMessage());
//            message = "Fail";
//            httpCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
//        }
//
//        metadataResponse.setMessage(message);
//        metadataResponse.setHttpCode(httpCode);
//        dataResponse.setData(show);
//
//        HandlerResponse handlerResponse = new HandlerResponse(metadataResponse, dataResponse);
//
//        return handlerResponse;
//    }

    //@Inject
    @RestClient
    IShowRestClient showRestClient;

    @Override
    public HandlerResponse getShowsById(Integer showId) {

        String message = "Success";
        Integer httpCode = Response.Status.OK.getStatusCode();

        HandlerResponse.MetadataResponse metadataResponse = new HandlerResponse.MetadataResponse();
        HandlerResponse.DataResponse dataResponse = new HandlerResponse.DataResponse();

        Show show = new Show();

        try{

            show = showRestClient.getShowById(showId);

        }catch (Exception ex){
            System.out.println("Error al obtener listado de shows por ID. Message: " + ex.getMessage());
            message = "Fail";
            httpCode = Response.Status.BAD_REQUEST.getStatusCode();
        }

        metadataResponse.setMessage(message);
        metadataResponse.setHttpCode(httpCode);
        dataResponse.setData(show);

        HandlerResponse handlerResponse = new HandlerResponse(metadataResponse, dataResponse);

        return handlerResponse;
    }

    @Override
    public HandlerResponse getShows() {

        String message = "Success";
        Integer httpCode = Response.Status.OK.getStatusCode();

        HandlerResponse.MetadataResponse metadataResponse = new HandlerResponse.MetadataResponse();
        HandlerResponse.DataResponse dataResponse = new HandlerResponse.DataResponse();

        List<Show> showList = new ArrayList<>();

        try{

            showList = showRestClient.getShows();

        }catch (Exception ex){
            System.out.println("Error al obtener listado de shows por ID. Message: " + ex.getMessage());
            message = "Fail";
            httpCode = Response.Status.BAD_REQUEST.getStatusCode();
        }

        metadataResponse.setMessage(message);
        metadataResponse.setHttpCode(httpCode);
        dataResponse.setData(showList);

        HandlerResponse handlerResponse = new HandlerResponse(metadataResponse, dataResponse);

        return handlerResponse;
    }
}
