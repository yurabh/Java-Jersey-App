package com.docker.jersey.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Env {
    @NotNull
    private String key;
    @NotNull
    private String value;
}
