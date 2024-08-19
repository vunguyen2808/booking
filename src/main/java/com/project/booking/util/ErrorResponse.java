package com.project.booking.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse extends AbstractJsonSerializable {
    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    @JsonProperty("errorFields")
    private List<ErrorField> errorFields;

    public static ErrorResponse of(String message, int status) {
        return of(message, status, null);
    }

    public static ErrorResponse of(String message, int status, List<ErrorField> errorFields) {
        ErrorResponse response = new ErrorResponse();
        response.setStatus(status);
        response.setMessage(message);
        response.setErrorFields(errorFields);
        return response;
    }
}
