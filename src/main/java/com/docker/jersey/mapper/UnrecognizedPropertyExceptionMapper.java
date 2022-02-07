package com.docker.jersey.mapper;

import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static com.docker.jersey.constant.ExceptionConstant.UNRECOGNIZED_PROPERTY;

@Provider
public class UnrecognizedPropertyExceptionMapper
        implements ExceptionMapper<UnrecognizedPropertyException> {
    @Override
    public Response toResponse(UnrecognizedPropertyException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(UNRECOGNIZED_PROPERTY)
                .build();
    }
}
