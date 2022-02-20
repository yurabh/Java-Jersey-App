package com.docker.jersey.service.impl;

import com.docker.jersey.model.DockerParameters;
import com.docker.jersey.service.DockerRegistrationService;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;

public class DockerRegistrationServiceImpl extends DockerRegistrationService {

    private static final Logger logger = Logger.getLogger(DockerRegistrationServiceImpl.class);

    @Override
    public Response createImage(DockerParameters dockerParameters) {
        logger.info("CreateImage method without realization in DockerRegistrationServiceImpl class ");
        return Response.status(501).build();
    }

    @Override
    public Response getImage(String dockerId) {
        logger.info("GetImage method without realization in DockerRegistrationServiceImpl class");
        return Response.status(501).build();
    }

    @Override
    public Response updateImage(String dockerId, DockerParameters dockerParameters) {
        logger.info("UpdateImage method without realization in DockerRegistrationServiceImpl class");
        return Response.status(501).build();
    }

    @Override
    public Response deleteImage(String dockerId) {
        logger.info("DeleteImage method without realization in DockerRegistrationServiceImpl class");
        return Response.status(501).build();
    }
}
