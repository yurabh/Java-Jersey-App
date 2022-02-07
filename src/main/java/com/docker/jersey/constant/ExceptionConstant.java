package com.docker.jersey.constant;

public final class ExceptionConstant {
    private ExceptionConstant() {

    }

    public static final String VALIDATION_EXCEPTION = "Couldn't validate input data please check input data";
    public static final String MAPPING_EXCEPTION = "Couldn't map input data please check your input data";
    public static final String PARSE_EXCEPTION = "Couldn't parse input data please check your input data";
    public static final String PROCESSING_EXCEPTION = "Couldn't processing input data please check your input data";
    public static final String UNRECOGNIZED_PROPERTY = "Entered unknown properties please check your input data";
    public static final String UNCAUGHT_EXCEPTION = "Something went wrong";
}