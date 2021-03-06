package com.learning.springboot.recordexample.config;

import com.learning.springboot.recordexample.RecordexampleApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(RecordexampleApplication.class);
    }
    
}
