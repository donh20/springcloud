package com.ncamc.springcloud.service.impl;

import com.ncamc.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String PaymentInfo(Integer id) {
        return "线程池: " + Thread.currentThread().getName()+" paymentInfo, id: "+id +"\t"+"OK";
    }

    @Override
    public String PaymentInfoTimeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch ( InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: " + Thread.currentThread().getName()+" paymentInfoTimeout, id: "+id +"\t"+"OK"+"耗时"+timeNumber+"秒钟";
    }
}