package io.michaelarnold.microservices.currencyconversionservice.controller;

import io.michaelarnold.microservices.currencyconversionservice.bean.CurrencyConversion;
import io.michaelarnold.microservices.currencyconversionservice.service.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        CurrencyConversion currencyConversion = proxy.getExchangeValue(from, to);

        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
                currencyConversion.getConversionMultiple(),
                currencyConversion.getConversionMultiple().multiply(quantity),
                currencyConversion.getEnvironment());

    }
}
