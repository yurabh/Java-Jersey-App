package com.docker.jersey.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static com.docker.jersey.constant.ExceptionConstant.PROCESSING_EXCEPTION;

@Provider
public class JSONProcessingExceptionMapper
        implements ExceptionMapper<JsonProcessingException> {
    @Override
    public Response toResponse(JsonProcessingException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(PROCESSING_EXCEPTION)
                .build();
    }
}
