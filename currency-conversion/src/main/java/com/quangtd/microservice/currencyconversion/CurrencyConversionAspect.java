package com.quangtd.microservice.currencyconversion;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CurrencyConversionAspect {

    @Before(value = "execution(* com.quangtd.microservice.currencyconversion.CurrencyConversionController.sampleMethod()) && args(a,b)")
    public void beforeConvertCurrency(JoinPoint joinPoint, String a, String b) {
        System.out.println("Before method:" + joinPoint.getSignature());
        System.out.println("aspect : " + a + b);
    }

    @After(value = "execution(* com.quangtd.microservice.currencyconversion.CurrencyConversionController.sampleMethod()) && args(a,b)  ")
    public void afterConvertCurrency(JoinPoint joinPoint, String a, String b) {
        System.out.println("After method:" + joinPoint.getSignature());
        System.out.println("aspect : " + a + b);
    }
}
