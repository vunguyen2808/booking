package com.project.booking.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.booking.util.RestApiUtil;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractSerializable implements Serializable {

    public static <T> T fromJson(String json, Class<T> clazz, T defaultValue) {
        return RestApiUtil.fromJson(json, clazz, defaultValue);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return fromJson(json, clazz, null);
    }

    public static String toJson(Object object, String defaultValue) {
        return RestApiUtil.toJson(object, defaultValue);
    }

    public static String toJson(Object object) {
        return RestApiUtil.toJson(object);
    }

    public String toJson() {
        return toJson(this);
    }
}
