package com.learn.springboot.demobean.configuration;

import com.learn.springboot.demobean.bean.Car;
import com.learn.springboot.demobean.bean.Engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class CarConfig {
    @Autowired
    private ApplicationContext appContext;

    @Value("${engineType}")
    private String engineType;

    @Bean
    public Car getCar() {
        Engine engine;
        switch (engineType) {
            case "gas":
                engine = (Engine) appContext.getBean("gas");
                break;
            case "electric":
                engine = (Engine) appContext.getBean("electric");
                break;
            case "hybrid":
                engine = (Engine) appContext.getBean("hybrid");
                break;
            default:
                engine = (Engine) appContext.getBean("electric");
                break;
        }

        return new Car(engine);
    }

    // @Bean
    // @Primary
    // public Car demoPrimaryAnnotation() {
    //     return new Car((Engine) appContext.getBean("hybrid"));
    // }

}
