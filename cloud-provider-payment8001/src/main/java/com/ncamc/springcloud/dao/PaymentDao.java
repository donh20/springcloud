package com.ncamc.springcloud.dao;

import com.ncamc.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/*
* 形成肌肉记忆：1. 只要有Dao，就上Mapper注解(repository注解可能会有问题)
* */
@Mapper
public interface PaymentDao {
    //写
    public int create(Payment payment);
    //读
    public Payment getPaymentById(@Param("id") Long id);
}
