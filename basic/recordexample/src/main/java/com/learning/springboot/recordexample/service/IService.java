package com.learning.springboot.recordexample.service;

import java.util.List;

public interface IService<T> {
    List<T> getAllItemObject();
}
