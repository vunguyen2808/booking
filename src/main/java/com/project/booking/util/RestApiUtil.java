package com.project.booking.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.util.StringUtils;
import ua_parser.Client;
import ua_parser.Parser;

import java.time.Instant;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

public class RestApiUtil {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false);

    public static <T> T fromJson(String json, TypeReference<T> clazz, T defaultValue) {
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

    public static Instant getStartOfDay(Instant instant) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(instant.toEpochMilli());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.toInstant();
    }

    public static Instant getEndOfDay(Instant instant) {
        Instant startOfDay = getStartOfDay(instant);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(startOfDay.toEpochMilli());
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.toInstant();
    }

    public static byte[] decodeBase64(String s) {
        return decodeBase64(s, null);
    }

    public static byte[] decodeBase64(String s, byte[] defaultValue) {
        try {
            byte[] decoded = Base64.getDecoder().decode(s);
            return decoded != null ? decoded : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
