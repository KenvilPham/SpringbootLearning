package com.learning.springboot.recordexample.service;

import java.util.ArrayList;
import java.util.List;

import com.learning.springboot.recordexample.model.Colour;

import org.springframework.stereotype.Service;

@Service
public class ColourService implements IService<Colour> {

    @Override
    public List<Colour> getAllItemObject() {
        List<Colour> colours = new ArrayList<>();
        colours.add(new Colour(1, 2, 3));
        colours.add(new Colour(1, 2, 3));
        colours.add(new Colour(1, 2, 3));
        return colours;
    }
    
}
