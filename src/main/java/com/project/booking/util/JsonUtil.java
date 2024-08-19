package com.project.booking.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.ArrayList;

public class JsonUtil {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .registerModule(new Jdk8Module())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);

    public static <T> T fromJson(byte[] json, TypeReference<T> clazz, T defaultValue) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static <T> T fromJson(String json, TypeReference<T> clazz, T defaultValue) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static <T> T fromJson(byte[] json, Class<T> clazz, T defaultValue) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz, T defaultValue) {
        try {
            return OBJECT_MAPPER.readValue(json, clazz);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static <T> ArrayList<T> fromJsonArray(String json, Class<T> clazz, ArrayList<T> defaultValue) {
        try {
            CollectionType list = OBJECT_MAPPER.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
            return OBJECT_MAPPER.readValue(json, list);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static String toJson(Object json) {
        return toJson(json, null);
    }

    public static String toJson(Object json, String defaultValue) {
        try {
            return OBJECT_MAPPER.writeValueAsString(json);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static byte[] toJsonAsBytes(Object json) {
        return toJsonAsBytes(json, null);
    }

    public static byte[] toJsonAsBytes(Object json, byte[] defaultValue) {
        try {
            return OBJECT_MAPPER.writeValueAsBytes(json);
        } catch (Exception e) {
            return defaultValue;
        }
    }

}
