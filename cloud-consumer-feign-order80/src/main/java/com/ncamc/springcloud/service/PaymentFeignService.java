package com.ncamc.springcloud.service;

import com.ncamc.springcloud.entities.CommonResult;
import com.ncamc.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/*
* 如果没有FeignClient注解,回想普通的cloud-consumer-order80模块里的controller,要自己写:
* 1. 服务的url
* 2. template
* 3. 负载均衡
* 4. 实现服务方的getmapping
* 就好像一个人去饭店吃饭,FeignClient相当于把饭馆的菜单拿过来了,没有Feign的话,客人需要自己写菜单
* !这里client端的Service接口就相当于是CLOUD-PAYMENT-SERVICE这个饭店(微服务提供方)的菜单,对方提供的菜(服务),我们直接点了开吃(调用)
* */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //代表80端口去Eureka上找
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
