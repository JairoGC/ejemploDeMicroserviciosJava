package com.jailux.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambioDivisasControlador {

	private Logger logger = LoggerFactory.getLogger(CambioDivisasControlador.class);
	
	@Autowired
	private CurrencyExchangeRepositorio repositorio;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		logger.info("retrieveExchangeValue llamado con {} {}", from, to);
		CurrencyExchange currencyExchange = repositorio.findByFromAndTo(from, to);
		if(currencyExchange == null) {
			throw new RuntimeException("No se encontro datos");
		}
		String port = environment.getProperty("local.server.port");
		currencyExchange.setEnvironment(port);
		
		return currencyExchange;
	}
}
