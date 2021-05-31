package com.learn.springboot.componentdemo.component;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ZipComponent {
    private String startDate;

    public ZipComponent() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        startDate = dateFormat.format(date);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "start date is: " + startDate;
    }

    
}
