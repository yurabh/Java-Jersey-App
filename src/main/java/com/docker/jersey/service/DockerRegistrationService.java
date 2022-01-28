package com.docker.jersey.service;

import com.docker.jersey.model.DockerParameters;

import javax.ws.rs.core.Response;

public abstract class DockerRegistrationService {
    public abstract DockerParameters createImage(DockerParameters dockerParameters);

    public abstract DockerParameters getImage(String dockerId);

    public abstract DockerParameters updateImage(String dockerId);

    public abstract DockerParameters deleteImage(String dockerId);
}
