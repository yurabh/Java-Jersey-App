package com.docker.jersey.restapi;

import com.docker.jersey.mapper.*;
import com.docker.jersey.model.DockerParameters;

import com.docker.jersey.service.DockerRegistrationService;

import com.docker.jersey.service.impl.DockerRegistrationServiceImpl;
import lombok.SneakyThrows;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.inmemory.InMemoryTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class DockerRegistrationApiTest extends JerseyTest {

    @Mock
    private DockerRegistrationServiceImpl mockDockerRegistrationServiceImpl;

    private DockerRegistrationApi dockerRegistrationApi;

    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new InMemoryTestContainerFactory();
    }

    @SneakyThrows
    @Override
    protected Application configure() {
        MockitoAnnotations.openMocks(this);
        dockerRegistrationApi = new DockerRegistrationApi(mockDockerRegistrationServiceImpl);
        return new ResourceConfig()
                .packages("com/docker/jersey")
                .property("applicationContext", "applicationContext.xml")
                .register(dockerRegistrationApi)
                .register(CustomValidationExceptionMapper.class)
                .register(JSONMappingExceptionMapper.class)
                .register(JSONParseExceptionMapper.class)
                .register(JSONProcessingExceptionMapper.class)
                .register(UncaughtExceptionMapper.class)
                .register(UnrecognizedPropertyExceptionMapper.class)
                .register(DockerRegistrationService.class);
    }

    @Test
    public void createImage_whenCorrectRequest_thenResponseIsNotImplemented() {
        Mockito.when(mockDockerRegistrationServiceImpl.createImage(any()))
                .thenReturn(Response.status(501).build());
        DockerParameters dockerParameters = ModelUtils.createDockerParameters();
        Response response = target("/dockerRegistration")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(dockerParameters, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
    }

    @Test
    public void createImage_whenJsonMappingCannotDeserializeJsonIntoObject_thenUnrecognizedPropertyExceptionWillBeThrown() {
        String json = "{\"from\": \"Ui\",\"labels\": [{\"key\": \"ui\", \"value\": \"ui\"}],"
                + "\"environments\": [{\"key\": \"ui\", \"value\": \"ui\" , \"valuesString\" : \"op\"}],"
                + "\"runs\": [\"ui\"],\"copies\": [\"ui\"],\"adds\": [\"ui\"]}";
        Response response = target("/dockerRegistration")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(json, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void createImage_whenJsonMappingCannotDeserializeJsonIntoObject_thenJsonParseExceptionWillBeThrown() {
        String json = "{'from': 'Ui','labels': [{'key': 'ui', 'value': 'ui'}],"
                + "'environments': [{'key': 'ui', 'value': 'ui'}],"
                + "'runs': ['ui'],'copies': ['ui'],'adds': ['ui']}";
        Response response = target("/dockerRegistration")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(json, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void getImage_whenCorrectRequest_thenResponseIsNotImplemented() {
        Mockito.when(mockDockerRegistrationServiceImpl.getImage("100"))
                .thenReturn(Response.status(501).build());
        Response response = target("/dockerRegistration/100")
                .request()
                .get();
        assertEquals(Response.Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
    }

    @Test
    public void getImage_whenValidationFailed_thenUncaughtExceptionWillBeThrown() {
        Response response = target("/dockerRegistration").request().get();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void updateImage_whenRequestIsCorrect_thenResponseIsNotImplemented() {
        Mockito.when(mockDockerRegistrationServiceImpl.updateImage(any(), any()))
                .thenReturn(Response.status(501).build());
        DockerParameters dockerParameters = ModelUtils.createDockerParameters();
        dockerParameters.setFrom("Oja");
        Response response = target("/dockerRegistration/100")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(dockerParameters, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
    }

    @Test
    public void updateImage_whenJsonMappingCannotDeserializeJsonIntoObject_thenUnrecognizedPropertyExceptionWillBeThrown() {
        String json = "{\"from\": \"Ui\",\"labels\": [{\"key\": \"ui\", \"value\": \"ui\"}],"
                + "\"environments\": [{\"key\": \"ui\", \"value\": \"ui\" , \"valuesString\" : \"op\"}],"
                + "\"runs\": [\"ui\"],\"copies\": [\"ui\"],\"adds\": [\"ui\"]}";
        Response response = target("/dockerRegistration/100")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(json, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void updateImage_whenJsonMappingCannotDeserializeJsonIntoObject_thenJsonParseExceptionWillBeThrown() {
        String json = "{'from': 'Ui','labels': [{'key': 'ui', 'value': 'ui'}],"
                + "'environments': [{'key': 'ui', 'value': 'ui','valuesString' : 'op'}],"
                + "'runs': ['ui'],'copies': ['ui'],'adds': ['ui']}";
        Response response = target("/dockerRegistration/100")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(json, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void deleteImage_whenRequestIsCorrect_thenResponseIsNotImplemented() {
        Mockito.when(mockDockerRegistrationServiceImpl.deleteImage("100"))
                .thenReturn(Response.status(501).build());
        Response response = target("/dockerRegistration/100")
                .request()
                .delete();
        assertEquals(Response.Status.NOT_IMPLEMENTED.getStatusCode(), response.getStatus());
    }

    @Test
    public void deleteImage_whenRequestIsNotCorrect_thenUncaughtExceptionWillBeThrown() {
        Response response = target("/dockerRegistration")
                .request()
                .delete();
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }
}
