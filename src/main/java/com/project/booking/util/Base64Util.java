package com.project.booking.util;

import java.util.Base64;

public class Base64Util {

    public static byte[] encodeBase64(byte[] src) {
        return encodeBase64(src, null);
    }

    public static byte[] encodeBase64(byte[] src, byte[] defaultValue) {
        try {
            byte[] encoded = Base64.getEncoder().encode(src);
            return encoded != null ? encoded : defaultValue;
        } catch (Exception ignored) {
            return defaultValue;
        }
    }

    public static String encodeBase64String(byte[] bytes) {
        return encodeBase64String(bytes, null);
    }

    public static String encodeBase64String(byte[] bytes, String defaultValue) {
        try {
            String encoded = Base64.getEncoder().encodeToString(bytes);
            return encoded != null ? encoded : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static byte[] encodeBase64Url(byte[] src) {
        return encodeBase64Url(src, null);
    }

    public static byte[] encodeBase64Url(byte[] src, byte[] defaultValue) {
        try {
            byte[] encoded = Base64.getUrlEncoder().withoutPadding().encode(src);
            return encoded != null ? encoded : defaultValue;
        } catch (Exception ignored) {
            return defaultValue;
        }
    }

    public static String encodeBase64UrlString(byte[] bytes) {
        return encodeBase64UrlString(bytes, null);
    }

    public static String encodeBase64UrlString(byte[] bytes, String defaultValue) {
        try {
            String encoded = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
            return encoded != null ? encoded : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public static byte[] decodeBase64(byte[] src) {
        return decodeBase64(src, null);
    }

    public static byte[] decodeBase64(byte[] src, byte[] defaultValue) {
        try {
            byte[] decoded = Base64.getDecoder().decode(src);
            return decoded != null ? decoded : defaultValue;
        } catch (Exception ignored) {
            return defaultValue;
        }
    }

    public static byte[] decodeBase64(String src) {
        return decodeBase64(src, null);
    }

    public static byte[] decodeBase64(String src, byte[] defaultValue) {
        try {
            byte[] decoded = Base64.getDecoder().decode(src);
            return decoded != null ? decoded : defaultValue;
        } catch (Exception ignored) {
            return defaultValue;
        }
    }

    public static byte[] decodeBase64Url(byte[] src) {
        return decodeBase64Url(src, null);
    }

    public static byte[] decodeBase64Url(byte[] src, byte[] defaultValue) {
        try {
            byte[] decoded = Base64.getUrlDecoder().decode(src);
            return decoded != null ? decoded : defaultValue;
        } catch (Exception ignored) {
            return defaultValue;
        }
    }

    public static byte[] decodeBase64Url(String src) {
        return decodeBase64Url(src, null);
    }

    public static byte[] decodeBase64Url(String src, byte[] defaultValue) {
        try {
            byte[] decoded = Base64.getUrlDecoder().decode(src);
            return decoded != null ? decoded : defaultValue;
        } catch (Exception ignored) {
            return defaultValue;
        }
    }

}
