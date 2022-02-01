package com.docker.jersey.model;

import lombok.Data;

import javax.validation.Valid;
import java.util.List;

@Data
public class DockerParameters {
    private String from;
    private List<@Valid Label> labels;
    private List<@Valid Env> environments;
    private List<String> runs;
    private List<String> copies;
    private List<String> adds;
    private String expose;
}
