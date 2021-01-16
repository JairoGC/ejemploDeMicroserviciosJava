package com.jailux.currencyexchangeservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerControlador {

	@GetMapping("/ejemplo-api")
	public String sampleApi() {
		return "api simple hola";
	}
	
}
