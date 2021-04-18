package com.in28minutes.microservices.currencyexchangeservice.controller;


import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    //allows us to get the value of the port # we set on line 23
    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping(value = "/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from, to);

        //simple runtime exception just incase we are unable to find the data
        if(currencyExchange ==null) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }

        //if we are able to find the data return this back

        //allowing us to get a port number back for our json response for environment
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        currencyExchangeRepository.findAll();
        return currencyExchange;
    }
}
