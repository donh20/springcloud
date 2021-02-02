package com.ncamc.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
* PaymentHystrixService这个微服务接口
* 找CLOUD-PROVIDER-HYSTRIX-PAYMENT这个服务去调用
* 对方可以提供两个服务(看对方的controller代码,就是对方饭店提供的菜单)
* 1. @GetMapping("/payment/hystrix/ok/{id}")
* 2. @GetMapping("/payment/hystrix/timeout/{id}")
* */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id);

}