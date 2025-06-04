package com.springboot.backend.resources;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import com.springboot.backend.entities.MainEntity;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = false)
public abstract class MainResource<T extends MainEntity> extends RepresentationModel {
    
    @JsonIgnore
    private T entity;

    @JsonIgnore
    Object[] args;

    @JsonProperty("id")
    private String entityId;
    private String name;
    private String description;

    public MainResource() {}

    public MainResource(T entity) {
        setEntity(entity);
        initAttributes();
    }

    public abstract void initAttributes();
}
