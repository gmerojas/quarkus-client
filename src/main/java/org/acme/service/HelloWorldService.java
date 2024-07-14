package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.contract.service.HelloWorldServiceInterface;
import org.acme.response.HandlerResponse;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class HelloWorldService implements HelloWorldServiceInterface {
    @Override
    public HandlerResponse helloWorld() {
        HandlerResponse.MetadataResponse metadataResponse = new HandlerResponse.MetadataResponse("Success", 200);
        HandlerResponse.DataResponse dataResponse = new HandlerResponse.DataResponse();

        List<String> data = new ArrayList<>();
        data.add("PHP");
        data.add("JAVA");
        data.add("PYTHON");
        data.add("C#");
        dataResponse.setData(data);

        HandlerResponse handlerResponse = new HandlerResponse(metadataResponse, dataResponse);

        return handlerResponse;
    }

    @Override
    public HandlerResponse helloWorld(String language) {
        String message = "Success";
        Integer httpCode = 200;

        HandlerResponse.MetadataResponse metadataResponse = new HandlerResponse.MetadataResponse();
        HandlerResponse.DataResponse dataResponse = new HandlerResponse.DataResponse();

        List<String> data = new ArrayList<>();
        data.add("PHP");
        data.add("JAVA");
        data.add("PYTHON");
        data.add("C#");

        if(!data.contains(language)){
            message = "Error";
            httpCode = 404;
            data = new ArrayList<>();
        }

        metadataResponse.setMessage(message);
        metadataResponse.setHttpCode(httpCode);
        dataResponse.setData(data);

        HandlerResponse handlerResponse = new HandlerResponse(metadataResponse, dataResponse);

        return handlerResponse;
    }
}
