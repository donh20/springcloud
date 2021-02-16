package com.ncamc.springcloud.service;

public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return null;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return null;
    }
}
