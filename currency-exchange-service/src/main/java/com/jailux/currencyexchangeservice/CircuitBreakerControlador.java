package com.jailux.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerControlador {

	private Logger logger = LoggerFactory.getLogger(CircuitBreakerControlador.class);
	
	@GetMapping("/ejemplo-api")
	@Retry(name="ejemplo-api", fallbackMethod = "hardcodeResponse")
	public String respuestaPredeterminadaEnCasoDeError() {
		logger.info("solicitando api con error");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:3848/error", String.class);
		return forEntity.getBody();
	}
	
	@GetMapping("/ejemplo-api-circuit")
	@CircuitBreaker(name="default", fallbackMethod = "hardcodeResponse")
	public String reintentarEnUnTiempoCadaVezMayor() {
		logger.info("solicitando api con error");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:3848/error", String.class);
		return forEntity.getBody();
	}
	
	@GetMapping("/ejemplo-api-rate")
	@RateLimiter(name="default")
	public String limiteDeSolicitudesPorSegundos() {
		return "llamada exitosa";
	}
	
	@GetMapping("/ejemplo-api-Bulkhead")
	@Bulkhead(name="default")
	public String llamadasSimultaneas() {
		return "llamada exitosa";
	}
	
	public String hardcodeResponse(Exception ex) {
		return "esta pasando un error";
	}
	
}
