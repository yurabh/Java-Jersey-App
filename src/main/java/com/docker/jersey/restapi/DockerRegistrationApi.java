package com.docker.jersey.restapi;

import com.docker.jersey.factory.FactoryService;
import com.docker.jersey.model.DockerParameters;
import com.docker.jersey.service.DockerRegistrationService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/dockerRegistration")
public class DockerRegistrationApi {
    private final FactoryService factoryService;

    @Inject
    public DockerRegistrationApi(FactoryService factoryService){
        this.factoryService = factoryService;
    }

    @POST
    public Response createImage(DockerParameters dockerParameters) {
        DockerRegistrationService dockerRegistrationService = factoryService.createDockerRegistrationService();
        DockerParameters createdImage = dockerRegistrationService.createImage(dockerParameters);
        return Response.status(501).entity(Optional.empty()).build();
    }

    @GET
    @Path("/{dockerId}")
    public Response getImage(@PathParam("dockerId") String dockerId) {
        DockerParameters foundImage = factoryService.createDockerRegistrationService().getImage(dockerId);
        return Response.status(501).entity(Optional.empty()).build();
    }

    @PUT
    @Path("/{dockerId}")
    public Response updateImage(@PathParam("dockerId") String dockerId) {
        DockerRegistrationService dockerRegistrationService = factoryService.createDockerRegistrationService();
        DockerParameters updateImage = dockerRegistrationService.updateImage(dockerId);
        return Response.status(501).entity(Optional.empty()).build();
    }

    @DELETE
    @Path("/{dockerId}")
    public Response deleteImage(@PathParam("dockerId") String dockerId) {
        DockerRegistrationService dockerRegistrationService = factoryService.createDockerRegistrationService();
        DockerParameters dockerParameters = dockerRegistrationService.deleteImage(dockerId);
        return Response.status(501).entity(Optional.empty()).build();
    }
}
