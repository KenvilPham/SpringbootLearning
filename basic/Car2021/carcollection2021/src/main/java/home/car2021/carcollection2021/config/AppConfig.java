package home.car2021.carcollection2021.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import home.car2021.carcollection2021.Carcollection2021Application;

@Configuration
public class AppConfig {
    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(Carcollection2021Application.class);
    }
}
