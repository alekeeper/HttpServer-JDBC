package org.example.utils;

import com.google.gson.Gson;

public class JsonUtils {

    private static final Gson gson = new Gson();

    public static <T> T parseFromJson(Class <T> clazz, String input) throws ClassNotFoundException {
        return gson.fromJson(input, clazz);
    }

    public static String parseToJson (Object object) {
        return gson.toJson(object);
    }
}

