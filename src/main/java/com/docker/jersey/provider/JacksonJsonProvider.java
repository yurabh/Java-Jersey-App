package com.docker.jersey.provider;

import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.ext.Provider;

@Provider
public class JacksonJsonProvider extends JacksonJaxbJsonProvider {
    public JacksonJsonProvider() {
        setMapper(ObjectMapperProvider.getInstance());
    }
}
