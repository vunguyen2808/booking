package com.project.booking.util;

import jakarta.servlet.UnavailableException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
public abstract class AbstractRestExceptionHandler {
    protected final MessageSource messageSource;
    protected final LocaleResolver localeResolver;
    protected final ThreadLocal<RestException> exceptionThread = new ThreadLocal<>();

    public AbstractRestExceptionHandler(MessageSource messageSource, LocaleResolver localeResolver) {
        this.messageSource = messageSource;
        this.localeResolver = localeResolver;
    }

    @ExceptionHandler(RestException.class)
    public ResponseEntity<RestResponse<?>> handleRestException(RestException ex, HttpServletRequest request) {
        RestResponse<?> response;
        if (ex.getErrorResponse() != null) {
            response = RestResponse.error(ex.getErrorResponse());
        } else {
            String errorMessage = messageSource.getMessage(ex.getMessage(), ex.getParams(), ex.getMessage(), localeResolver.resolveLocale(request));
            response = RestResponse.error(errorMessage, ex.getStatus().value(), null);
        }
        return ResponseEntity.status(resolveHttpStatus(ex.getStatus())).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestResponse<?>> handleException(Exception ex, HttpServletRequest request) {
        RestException restException = exceptionThread.get();
        if (restException != null) {
            return handleRestException(restException, request);
        }
        String errorMessage = messageSource.getMessage(ex.getMessage(), null, ex.getMessage(), localeResolver.resolveLocale(request));
        HttpStatus status = resolveHttpStatus(ex);
        RestResponse<?> response = RestResponse.error(errorMessage, status.value(), null);
        return ResponseEntity.status(resolveHttpStatus(status)).body(response);
    }

    public HttpStatus resolveHttpStatus(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ex instanceof AuthenticationException) {
            status = HttpStatus.UNAUTHORIZED;
        }
        if (ex instanceof AccessDeniedException) {
            status = HttpStatus.FORBIDDEN;
        }
        if (ex instanceof ServletRequestBindingException
                || ex instanceof HttpMediaTypeException
                || ex instanceof HttpRequestMethodNotSupportedException) {
            status = HttpStatus.BAD_REQUEST;
        }
        if (ex instanceof NoResourceFoundException || ex instanceof NoHandlerFoundException) {
            status = HttpStatus.NOT_FOUND;
        }
        if (ex instanceof UnavailableException) {
            status = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS;
        }
        return status;
    }

    public HttpStatus resolveHttpStatus(HttpStatus status) {
        return status;
    }

}
