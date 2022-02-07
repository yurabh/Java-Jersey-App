package com.docker.jersey.config;

import com.docker.jersey.mapper.*;
import com.docker.jersey.restapi.DockerRegistrationApi;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("com/docker/jersey");
        register(DockerRegistrationApi.class);
        register(JacksonFeature.class);
        register(CustomValidationExceptionMapper.class);
        register(JSONMappingExceptionMapper.class);
        register(JSONParseExceptionMapper.class);
        register(JSONProcessingExceptionMapper.class);
        register(UncaughtExceptionMapper.class);
        register(UnrecognizedPropertyExceptionMapper.class);
    }
}
