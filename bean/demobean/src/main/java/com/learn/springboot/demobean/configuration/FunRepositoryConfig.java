package com.learn.springboot.demobean.configuration;
import com.learn.springboot.demobean.bean.FunRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FunRepositoryConfig {
    @Value("${engineType}")
    private String engineType;

    @Bean
    public FunRepository funRepo() {
        return new FunRepository(engineType);
    }

}
