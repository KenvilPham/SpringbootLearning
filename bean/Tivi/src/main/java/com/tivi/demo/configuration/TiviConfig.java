package com.tivi.demo.configuration;

import com.tivi.demo.bean.OperationSystem;
import com.tivi.demo.bean.Panel;
import com.tivi.demo.bean.Tivi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TiviConfig {
    @Autowired
    private ApplicationContext context;

    @Value("${panel}")
    private String panelType;

    @Value("${os}")
    private String osType;

    @Bean
    public Tivi getTivi() {
        Panel panel;
        OperationSystem os;

        switch (panelType.toLowerCase()) {
            case "led":
                panel = (Panel) context.getBean("led");
                break;
            case "oled":
            default:
                panel = (Panel) context.getBean("oled");
                break;
        }

        switch (osType.toLowerCase()) {
            case "ios":
                os = (OperationSystem) context.getBean("ios");
                break;
            case "android":
                os = (OperationSystem) context.getBean("android");
                break;
            case "flutter":
                os = (OperationSystem) context.getBean("flutter");
                break;
            case "normal":
            default:
                os = (OperationSystem) context.getBean("normal");
                break;
        }

        return new Tivi(panel, os);
    }
}
