package com.docker.jersey.mapper;

import com.fasterxml.jackson.databind.JsonMappingException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static com.docker.jersey.constant.ExceptionConstant.MAPPING_EXCEPTION;

@Provider
public class JSONMappingExceptionMapper
        implements ExceptionMapper<JsonMappingException> {
    @Override
    public Response toResponse(JsonMappingException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(MAPPING_EXCEPTION)
                .build();
    }
}
