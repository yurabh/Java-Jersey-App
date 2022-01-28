package com.docker.jersey.restapi;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/dockerRegistration/")
public class DockerRegistrationApi {
    @POST
    public Response createImage() {
        return Response.status(201).entity(Optional.empty()).build();
    }

    @GET
    public Response getImage() {
        return Response.status(201).entity(Optional.empty()).build();
    }

    @PUT
    public Response updateImage() {
        return Response.status(204).entity(Optional.empty()).build();
    }

    @DELETE
    public Response deleteImage() {
        return Response.status(202).entity(Optional.empty()).build();
    }
}
