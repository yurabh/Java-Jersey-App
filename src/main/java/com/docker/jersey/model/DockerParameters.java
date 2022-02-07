package com.docker.jersey.model;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class DockerParameters {
    @NotNull
    private String from;
    private List<@Valid Label> labels;
    private List<@Valid Env> environments;
    private List<String> runs;
    private List<String> copies;
    private List<String> adds;
    private String expose;
}
