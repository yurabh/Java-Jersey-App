package com.docker.jersey.service;

import com.docker.jersey.model.DockerParameters;

import javax.ws.rs.core.Response;

public abstract class DockerRegistrationService {
    public abstract Response createImage(DockerParameters dockerParameters);

    public abstract Response getImage(String dockerId);

    public abstract Response updateImage(String dockerId);

    public abstract Response deleteImage(String dockerId);
}
