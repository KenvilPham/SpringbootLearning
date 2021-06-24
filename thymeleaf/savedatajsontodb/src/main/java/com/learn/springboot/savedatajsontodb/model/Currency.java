package com.learn.springboot.savedatajsontodb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "currencyrate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    @Id
    private String currencyCode;

    @Column(name = "currency_value")
    private double conversionRate;
}
