package io.michaelarnold.microservices.currencyexcahngeservice.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyExchange {
    private long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;

    public CurrencyExchange(long id, String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
}
