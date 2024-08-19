package com.project.booking.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractJsonSerializable implements Serializable {
    public String toJson() {
        try {
            return JsonUtil.toJson(this);
        } catch (Exception e) {
            return "{}";
        }
    }
}
