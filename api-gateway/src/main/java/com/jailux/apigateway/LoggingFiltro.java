package com.jailux.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFiltro implements GlobalFilter{

	private Logger logger = LoggerFactory.getLogger(LoggingFiltro.class);
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Ruta de la solicitud recibida -> {}", exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}
