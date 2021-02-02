package com.ncamc.springcloud.controller;

import com.ncamc.springcloud.entities.CommonResult;
import com.ncamc.springcloud.entities.Payment;
import com.ncamc.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
* 因为开启了Feign注解,所以消费者直接可以拿到菜单开始点餐吃饭了
* */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    /*
    * 客户端访问/consumer/payment/get/{id},找到客户端80端口的PaymentFeignService
    * 而PaymentFeignService开启Feign注解,去Eureka上找CLOUD-PAYMENT-SERVICE 8001/8002
    * 找的是controller
    * */
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon,客户端一般默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }
}
