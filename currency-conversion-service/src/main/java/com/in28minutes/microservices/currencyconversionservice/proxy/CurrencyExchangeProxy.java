package com.in28minutes.microservices.currencyconversionservice.proxy;

import com.in28minutes.microservices.currencyconversionservice.model.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//grabbing our currency-exchange microservice we created
@FeignClient(name = "currency-exchange", url="localhost:8000")
public interface CurrencyExchangeProxy {

    //created a proxy to call the currency exchange url to grab the data
    //created the CurrencyConversion bean matching the structure of the response of the currency-exchange
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
