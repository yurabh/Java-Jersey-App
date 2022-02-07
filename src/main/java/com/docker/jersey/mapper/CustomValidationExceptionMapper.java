package com.docker.jersey.mapper;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static com.docker.jersey.constant.ExceptionConstant.VALIDATION_EXCEPTION;

@Provider
public class CustomValidationExceptionMapper
        implements ExceptionMapper<ConstraintViolationException> {
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(VALIDATION_EXCEPTION)
                .build();
    }
}
