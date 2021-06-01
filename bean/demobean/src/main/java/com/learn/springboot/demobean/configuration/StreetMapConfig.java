package com.learn.springboot.demobean.configuration;

import com.learn.springboot.demobean.bean.StreetMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class StreetMapConfig {
    @Bean
    @Scope("prototype")
    public StreetMap streetMap() {
        return new StreetMap();
    }
}
