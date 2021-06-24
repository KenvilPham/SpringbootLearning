package com.learn.springboot.savedatajsontodb.task;

import com.learn.springboot.savedatajsontodb.model.Currency;
import com.learn.springboot.savedatajsontodb.model.CurrencyDTO;
import com.learn.springboot.savedatajsontodb.repository.CurrencyRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyTask {
    @Autowired
    private CurrencyRepository repository;

    @Value("${exchangerate.apikey}")
    private String exchangeRateApiKey;

    @Scheduled(fixedRate = 12 * 1000 * 60 * 60)
    private void getRatesTask() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrencyDTO dtoObject = restTemplate.getForObject(exchangeRateApiKey, CurrencyDTO.class);
            dtoObject.getConversion_rates().forEach((key, value) -> {
                Currency currency = new Currency(key, value);
                repository.save(currency);
            });
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
    }
}
