package com.ncamc.springcloud.service.impl;

import com.ncamc.springcloud.dao.PaymentDao;
import com.ncamc.springcloud.entities.Payment;
import com.ncamc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
* 形成肌肉记忆：3.service的实现类要增加Service注解
* */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    //写
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    //读
    public Payment getPaymentById(@Param("id") Long id){
        return paymentDao.getPaymentById(id);
    }
}
