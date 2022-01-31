package com.docker.jersey.factory;

import com.docker.jersey.service.impl.DockerRegistrationServiceImpl;
import com.docker.jersey.service.DockerRegistrationService;

public class FactoryService {
    public static DockerRegistrationService createDockerRegistrationService() {
        return new DockerRegistrationServiceImpl();
    }
}
