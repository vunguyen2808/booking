package com.project.booking.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorField extends AbstractJsonSerializable {
    @JsonProperty("field")
    private String field;

    @JsonProperty("value")
    private String value;

    @JsonProperty("message")
    private String message;
}
