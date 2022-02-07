package com.docker.jersey.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static com.docker.jersey.constant.ExceptionConstant.UNCAUGHT_EXCEPTION;

@Provider
public class UncaughtExceptionMapper
        implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(UNCAUGHT_EXCEPTION)
                .build();
    }
}
