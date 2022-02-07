package com.docker.jersey.restapi;

import com.docker.jersey.model.DockerParameters;
import com.docker.jersey.model.Env;
import com.docker.jersey.model.Label;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.inmemory.InMemoryTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Arrays;
import java.util.List;

public class JerseyDockerRegistrationApiTest extends JerseyTest {
    @Override
    protected TestContainerFactory getTestContainerFactory() {
        return new InMemoryTestContainerFactory();
    }

    @Override
    protected Application configure() {
        return new ResourceConfig().packages("com/docker/jersey");
    }

    @Test
    public void test() {
        DockerParameters dockerParameters = new DockerParameters();
        dockerParameters.setFrom("Ui");
        dockerParameters.setExpose("Ui");
        Label label = new Label();
        label.setKey("ui");
        label.setValue("ui");
        List<Label> labels = Arrays.asList(label, label);
        dockerParameters.setLabels(labels);
        Env env = new Env();
        env.setKey("ui");
        env.setValue("ui");
        List<Env> environments = Arrays.asList(env, env);
        dockerParameters.setEnvironments(environments);
        dockerParameters.setRuns(Arrays.asList("Ui", "Ui"));
        dockerParameters.setCopies(Arrays.asList("Ui", "Ui"));
        dockerParameters.setAdds(Arrays.asList("Ui", "Ui"));


        Response response = target("/dockerRegistration").request().post(Entity.entity(dockerParameters, MediaType.APPLICATION_JSON_TYPE));
    }
}
