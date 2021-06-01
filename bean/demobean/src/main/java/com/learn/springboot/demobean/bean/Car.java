package com.learn.springboot.demobean.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
    
    @Autowired
    @Qualifier("manualSteering")
    private ISteering steering;

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car [engine=" + engine + ", steering=" + steering.steer() + "]";
    }

    
}
