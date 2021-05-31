package com.learn.springboot.componentdemo.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextAwareDemoComponent implements ApplicationContextAware{

    @Autowired
    private ApplicationContext appContext1;

    private ApplicationContext appContext2;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // TODO Auto-generated method stub
        this.appContext2 = applicationContext;
    }
    
    public String getBothApplicationContext() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("appContext1: " + appContext1.getDisplayName() + "<br>");
        stringBuilder.append("appContext2: " + appContext2.getDisplayName());
        return stringBuilder.toString();
    }
}
