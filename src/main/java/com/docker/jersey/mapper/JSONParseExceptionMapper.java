package com.docker.jersey.mapper;

import com.fasterxml.jackson.core.JsonParseException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static com.docker.jersey.constant.ExceptionConstant.PARSE_EXCEPTION;

@Provider
public class JSONParseExceptionMapper
        implements ExceptionMapper<JsonParseException> {
    @Override
    public Response toResponse(JsonParseException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(PARSE_EXCEPTION)
                .build();
    }
}
