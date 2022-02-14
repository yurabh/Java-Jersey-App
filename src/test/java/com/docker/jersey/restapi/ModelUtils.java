package com.docker.jersey.restapi;

import com.docker.jersey.model.DockerParameters;
import com.docker.jersey.model.Env;
import com.docker.jersey.model.Label;

import java.util.Arrays;

public class ModelUtils {
    public static DockerParameters createDockerParameters() {
        return DockerParameters.builder()
                .from("ui")
                .environments(Arrays.asList(Env.builder().key("key").value("value").build(),
                        Env.builder().key("ui").value("ui").build()))
                .labels(Arrays.asList(Label.builder().key("ui").value("ui").build(),
                        Label.builder().key("ui").value("ui").build()))
                .runs(Arrays.asList("Ui", "Ui"))
                .copies(Arrays.asList("Ui", "Ui"))
                .adds(Arrays.asList("Ui", "Ui"))
                .expose("Ui")
                .build();
    }
}
