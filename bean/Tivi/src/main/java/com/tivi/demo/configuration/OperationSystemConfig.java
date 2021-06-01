package com.tivi.demo.configuration;

import com.tivi.demo.bean.OperationSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationSystemConfig {

    @Bean(name = "normal")
    public OperationSystem normalTivi() {
        return new OperationSystem("Normal Tivi");
    }

    @Bean(name = "ios")
    public OperationSystem iOSTivi() {
        return new OperationSystem("IOS");
    }

    @Bean(name = "android")
    public OperationSystem androidTivi() {
        return new OperationSystem("Android");
    }

    @Bean(name = "flutter")
    public OperationSystem flutterTivi() {
        return new OperationSystem("Flutter");
    }
}
