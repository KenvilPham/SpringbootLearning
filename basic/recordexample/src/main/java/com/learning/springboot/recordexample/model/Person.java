package com.learning.springboot.recordexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Person(@JsonProperty("id") long id, 
                    @JsonProperty("name") String fullName,
                    @JsonProperty("email") String email) {
    
}
