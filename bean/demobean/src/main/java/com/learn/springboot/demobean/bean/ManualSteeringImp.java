package com.learn.springboot.demobean.bean;

public class ManualSteeringImp implements ISteering {

    @Override
    public String steer() {
        return "Manual steering";
    }
    
}
