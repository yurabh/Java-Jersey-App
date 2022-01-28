package com.docker.jersey.restapi;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/dockerRegistration")
public class DockerRegistrationApi {
    @POST
    public Response createImage() {
        return Response.status(501).entity(Optional.empty()).build();
    }

    @GET
    @Path("/{dockerId}")
    public Response getImage(@PathParam("dockerId") String dockerId) {
        return Response.status(501).entity(Optional.empty()).build();
    }

    @PUT
    @Path("/{dockerId}")
    public Response updateImage(@PathParam("dockerId") String dockerId) {
        return Response.status(501).entity(Optional.empty()).build();
    }

    @DELETE
    @Path("/{dockerId}")
    public Response deleteImage(@PathParam("dockerId") String dockerId) {
        return Response.status(501).entity(Optional.empty()).build();
    }
}
