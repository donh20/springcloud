package com.ncamc.springcloud.controller;

import com.ncamc.springcloud.entities.CommonResult;
import com.ncamc.springcloud.entities.Payment;
import com.ncamc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymentController {
    /*前后端分离,controller层最后要传CommonResult*/
    @Resource
    private PaymentService paymentService;

    /*数据库的操作者，发Post请求*/
    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果："+result);
        if (result>0) {
            return new CommonResult(200,"插入数据成功",result);
        } else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    /*数据库的操作者，发Get请求*/
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果："+payment);
        if (payment!=null) {
            return new CommonResult(200,"查询数据库成功",payment);
        } else {
            return new CommonResult(444,"没有对应记录,查询id"+id,null);
        }
    }
}
