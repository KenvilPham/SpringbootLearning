package com.learn.springboot.demobean.configuration;

import com.learn.springboot.demobean.bean.Engine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EngineConfig {
    @Bean(name = "gas")
    public Engine gasEngine() {
        return new Engine("Gar engine");
    }

    @Bean(name = "electric")
    public Engine electricEngine() {
        return new Engine("Electric engine");
    }

    @Bean(name = "hybrid")
    public Engine hybridEngine() {
        return new Engine("Hybrid engine");
    }
}
