package com.ncamc.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

public interface PaymentService {

    //正常访问
    public String paymentInfo_OK(Integer id);
    //超时访问
    public String paymentInfo_TimeOut(Integer id);

    public String paymentInfo_TimeOutHandler(Integer id);

}
