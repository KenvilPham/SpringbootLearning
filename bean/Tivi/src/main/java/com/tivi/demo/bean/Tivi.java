package com.tivi.demo.bean;

public class Tivi {

    private Panel panel;
    private OperationSystem os;

    public Tivi(Panel panel, OperationSystem os) {
        this.panel = panel;
        this.os = os;
    }

    @Override
    public String toString() {
        return "Tivi{" +
                "panel=" + panel +
                ", os=" + os +
                '}';
    }
}
