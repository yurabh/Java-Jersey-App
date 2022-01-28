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
    @Path("/{id}")
    public Response getImage(@PathParam("id") int id) {
        return Response.status(501).entity(Optional.empty()).build();
    }

    @PUT
    @Path("/{param}")
    public Response updateImage(@PathParam("param") String param) {
        return Response.status(501).entity(Optional.empty()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteImage(@PathParam("id") int id) {
        return Response.status(501).entity(Optional.empty()).build();
    }
}
