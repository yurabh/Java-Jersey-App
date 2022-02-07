package com.docker.jersey.provider;

import com.fasterxml.jackson.databind.ObjectMapper;

public final class ObjectMapperProvider {
    private static ObjectMapper objectMapper;

    public static ObjectMapper getInstance() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            return objectMapper;
        }
        return objectMapper;
    }
}
