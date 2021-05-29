package com.learning.springboot.recordexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "color")
public record Color(
    @Id @GeneratedValue int id,
    @JsonProperty("Red") int R,
    @JsonProperty("Green") int G,
    @JsonProperty("Blue") int B) {}

