package com.learn.springboot.demobean.configuration;

import com.learn.springboot.demobean.bean.AutoSteeringImp;
import com.learn.springboot.demobean.bean.ManualSteeringImp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SteeringConfig {
    @Bean
    public AutoSteeringImp autoSteering() {
        return new AutoSteeringImp();
    }

    @Bean
    public ManualSteeringImp manualSteering() {
        return new ManualSteeringImp();
    }

}
