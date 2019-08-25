package com.pawan.spring.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyExchnageServiceProxy cesp;
	
	private Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
	
	@GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		Map<String,String> uriVariables = new HashMap<String,String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> forEntity = new RestTemplate().getForEntity("http://localhost:3000/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class, uriVariables);
		CurrencyConversion body = forEntity.getBody();
		return new CurrencyConversion(body.getId(), "USD", "INR", body.getConversionMultiple(), quantity, quantity.multiply(body.getConversionMultiple()), body.getPort());
	}
	
	@GetMapping(path = "/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion convertCurrencyfeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
		CurrencyConversion body = cesp.reteriveCurrencyValue(from, to);
		
		logger.info("CurrencyConversion - > {}" , body );
				
		return new CurrencyConversion(body.getId(), "USD", "INR", body.getConversionMultiple(), quantity, quantity.multiply(body.getConversionMultiple()), body.getPort());
	}

}
