package com.learn.springboot.demobean.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

public class Car {
    
    @Autowired
    @Qualifier("manualSteering")
    private ISteering steering;

    private Engine engine;

    @Autowired
    @Lazy
    private StreetMap streetMap;

    public Car(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", steering=" + steering.steer() + "]";
    }

    public String navigation() {
        return streetMap.getRoute();
    }
    
}
