package com.project.booking.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestResponse<S> extends AbstractJsonSerializable {
    @JsonProperty("timestamp")
    private Instant timestamp = Instant.now();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("success")
    private S success;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("error")
    private ErrorResponse error;

    public static <S> RestResponse<S> success(S success) {
        RestResponse<S> response = new RestResponse<>();
        response.setSuccess(success);
        return response;
    }

    public static <S> RestResponse<S> error(ErrorResponse error) {
        RestResponse<S> response = new RestResponse<>();
        response.setError(error);
        return response;
    }

    public static <S> RestResponse<S> error(String message, HttpStatus status) {
        return error(message, status.value(), null);
    }

    public static <S> RestResponse<S> error(String message, int status) {
        return error(message, status, null);
    }

    public static <S> RestResponse<S> error(String message, int status, List<ErrorField> errorFields) {
        RestResponse<S> response = new RestResponse<>();
        response.setError(ErrorResponse.of(message, status, errorFields));
        return response;
    }

    public static <S> RestResponse<S> fromJson(String json) {
        return JsonUtil.fromJson(json, new TypeReference<>() {
        }, null);
    }
}
