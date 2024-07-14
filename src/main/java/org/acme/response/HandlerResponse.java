package org.acme.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RegisterForReflection
public class HandlerResponse {

    @JsonProperty("metadata")
    MetadataResponse metadata;

    @JsonProperty("data")
    DataResponse data;

    @Data
    @NoArgsConstructor
    @RegisterForReflection
    public static class MetadataResponse{
        String message;
        Integer httpCode;
        Date date = new Date();

        public MetadataResponse (String message, Integer httpCode){
            this.message = message;
            this.httpCode = httpCode;
        }
    }

    @Data
    @NoArgsConstructor
    @RegisterForReflection
    public static class DataResponse{
        Object data;
    }
}
