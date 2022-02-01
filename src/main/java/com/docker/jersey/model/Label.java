package com.docker.jersey.model;

import javax.validation.constraints.NotNull;

public class Label {
    @NotNull
    private String key;
    @NotNull
    private String value;
}
