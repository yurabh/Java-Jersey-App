package com.docker.jersey.restapi;

import com.docker.jersey.factory.FactoryService;
import com.docker.jersey.model.DockerParameters;
import com.docker.jersey.service.DockerRegistrationService;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/dockerRegistration")
@Produces("application/json")
@Consumes("application/json")
@AllArgsConstructor
public class DockerRegistrationApi {

    private static final Logger logger = Logger.getLogger(DockerRegistrationApi.class);
    private DockerRegistrationService delegate;

    public DockerRegistrationApi() {
        this.delegate = FactoryService.createDockerRegistrationService();
        logger.info("Object created in constructor by default");
    }

    @POST
    public Response createImage(@NotNull @Valid DockerParameters dockerParameters) {
        logger.info("Method createImage without realization in DockerRegistrationApi class");
        return delegate.createImage(dockerParameters);
    }

    @GET
    @Path("/{dockerId}")
    public Response getImage(@NotNull @PathParam("dockerId") String dockerId) {
        logger.info("Method getImage without realization in DockerRegistrationApi class");
        return delegate.getImage(dockerId);
    }

    @PUT
    @Path("/{dockerId}")
    public Response updateImage(@NotNull @PathParam("dockerId") String dockerId, @NotNull @Valid DockerParameters dockerParameters) {
        logger.info("Method update Image without realization in DockerRegistrationApi class");
        return delegate.updateImage(dockerId, dockerParameters);
    }

    @DELETE
    @Path("/{dockerId}")
    public Response deleteImage(@NotNull @PathParam("dockerId") String dockerId) {
        logger.info("Method deleteImage without realization in DockerRegistrationApi class");
        return delegate.deleteImage(dockerId);
    }
}
