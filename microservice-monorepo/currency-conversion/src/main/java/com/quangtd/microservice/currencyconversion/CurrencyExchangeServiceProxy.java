package com.quangtd.microservice.currencyconversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FOREX-SERVICE")
@RibbonClient(name = "FOREX-SERVICE")
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue
            (@PathVariable("from") String from, @PathVariable("to") String to);
}