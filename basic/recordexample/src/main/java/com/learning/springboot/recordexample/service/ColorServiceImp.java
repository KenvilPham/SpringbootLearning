package com.learning.springboot.recordexample.service;

import java.util.ArrayList;
import java.util.List;

import com.learning.springboot.recordexample.model.Color;

import org.springframework.stereotype.Service;

@Service
public class ColorServiceImp implements IService<Color> {

    @Override
    public List<Color> getAllItemObject() {
        List<Color> colors = new ArrayList<>();
		colors.add(new Color(1, 12, 15, 255));
		colors.add(new Color(2, 255, 0, 0));
		colors.add(new Color(3, 0, 255, 0));
		colors.add(new Color(4, 0, 0, 255));
        return colors;
    }
    
    
}
