package com.springboot.backend.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Data
public class AccountRequest {
    
    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("privilege")
    private Integer privilege;

    @JsonProperty("phoneNumber")
    private String phoneNumber;
}
