package com.project.booking.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RestException extends RuntimeException {
    private HttpStatus status;
    private Object[] params;
    private ErrorResponse errorResponse;

    public RestException(String message) {
        super(message);
    }

    public static RestException notFound(String message, Object... params) {
        return new RestException(message).status(HttpStatus.NOT_FOUND).params(params);
    }

    public static RestException badRequest(String message, Object... params) {
        return new RestException(message).status(HttpStatus.BAD_REQUEST).params(params);
    }

    public static RestException forbidden(String message, Object... params) {
        return new RestException(message).status(HttpStatus.FORBIDDEN).params(params);
    }

    public static RestException unauthorized(String message, Object... params) {
        return new RestException(message).status(HttpStatus.UNAUTHORIZED).params(params);
    }

    public static RestException serviceUnavailable(String message, Object... params) {
        return new RestException(message).status(HttpStatus.SERVICE_UNAVAILABLE).params(params);
    }

    public static RestException internalServerError(String message, Object... params) {
        return new RestException(message).status(HttpStatus.INTERNAL_SERVER_ERROR).params(params);
    }

    public RestException status(HttpStatus status) {
        this.status = status;
        return this;
    }

    public RestException params(Object[] params) {
        this.params = params;
        return this;
    }

    public RestException errorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
        return this;
    }
}
