package com.docker.jersey.service.impl;

import com.docker.jersey.model.DockerParameters;
import com.docker.jersey.service.DockerRegistrationService;

import javax.ws.rs.core.Response;

public class DockerRegistrationServiceImpl extends DockerRegistrationService {
    @Override
    public DockerParameters createImage(DockerParameters dockerParameters) {
        return null;
    }

    @Override
    public DockerParameters getImage(String dockerId) {
        return null;
    }

    @Override
    public DockerParameters updateImage(String dockerId) {
        return null;
    }

    @Override
    public DockerParameters deleteImage(String dockerId) {
        return null;
    }
}
