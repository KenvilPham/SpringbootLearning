package com.tivi.demo.bean;

public class Panel {
    private String panelType;

    public Panel(String panelType) {
        this.panelType = panelType;
    }

    public String getPanelType() {
        return panelType;
    }

    public void setPanelType(String panelType) {
        this.panelType = panelType;
    }

    @Override
    public String toString() {
        return panelType;
    }
}
