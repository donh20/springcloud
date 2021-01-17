package com.ncamc.springcloud.service;

import com.ncamc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/*
* 形成肌肉记忆：2. 只要有service，就要写interface，方法跟dao的保持一致，与此同时要新增对应的实现类(impl)
* */
public interface PaymentService {
    //写
    public int create(Payment payment);
    //读
    public Payment getPaymentById(@Param("id") Long id);
}

