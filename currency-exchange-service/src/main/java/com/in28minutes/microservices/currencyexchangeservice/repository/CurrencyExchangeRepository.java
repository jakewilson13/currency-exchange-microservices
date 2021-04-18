package com.in28minutes.microservices.currencyexchangeservice.repository;

import com.in28minutes.microservices.currencyexchangeservice.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    //implementation provided by spring data jpa
    //converts this into a sql query where you query the table by FromAndTo
   CurrencyExchange findByFromAndTo(String from, String to);
}
