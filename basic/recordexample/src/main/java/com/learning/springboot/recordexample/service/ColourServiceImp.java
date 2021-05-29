package com.learning.springboot.recordexample.service;

import java.util.ArrayList;
import java.util.List;

import com.learning.springboot.recordexample.model.Colour;

import org.springframework.stereotype.Service;

@Service
public class ColourServiceImp implements IService<Colour> {

    @Override
    public List<Colour> getAllItemObject() {
        List<Colour> colours = new ArrayList<>();
		colours.add(new Colour(12, 15, 255));
		colours.add(new Colour(255, 0, 0));
		colours.add(new Colour(0, 255, 0));
		colours.add(new Colour(0, 0, 255));
        return colours;
    }
    
}
