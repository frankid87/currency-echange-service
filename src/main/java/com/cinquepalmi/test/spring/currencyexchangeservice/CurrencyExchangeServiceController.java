package com.cinquepalmi.test.spring.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cinquepalmi.test.spring.currencyexchangeservice.properties.PropertyResolver;
import com.cinquepalmi.test.spring.currencyexchangeservice.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeServiceController {
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@Autowired
	private PropertyResolver propertyResolver;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(propertyResolver.getPort());
		return exchangeValue;
	}
}
