package io.michaelarnold.microservices.currencyexcahngeservice.data;

import io.michaelarnold.microservices.currencyexcahngeservice.bean.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository
        extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromAndTo(String from, String to);
}
