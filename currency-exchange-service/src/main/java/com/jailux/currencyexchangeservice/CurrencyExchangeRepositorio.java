package com.jailux.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepositorio extends JpaRepository<CurrencyExchange, Long>{
	CurrencyExchange findByFromAndTo(String frond, String to);
}
