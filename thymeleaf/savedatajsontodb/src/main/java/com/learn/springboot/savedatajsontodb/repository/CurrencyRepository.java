package com.learn.springboot.savedatajsontodb.repository;

import com.learn.springboot.savedatajsontodb.model.Currency;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, String> {
    
}
