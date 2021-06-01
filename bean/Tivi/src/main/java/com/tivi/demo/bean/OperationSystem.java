package com.tivi.demo.bean;

public class OperationSystem {
    private String OSType;

    public OperationSystem(String OSType) {
        this.OSType = OSType;
    }

    public String getOSType() {
        return OSType;
    }

    public void setOSType(String OSType) {
        this.OSType = OSType;
    }

    @Override
    public String toString() {
        return OSType;
    }
}
