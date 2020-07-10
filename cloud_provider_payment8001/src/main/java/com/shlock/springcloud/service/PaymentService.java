package com.shlock.springcloud.service;/*
    @author Shlock
    @create date 2020-07-10 13:25    
*/

import com.shlock.springcloud.entities.Payment;

public interface PaymentService {
    public int create(Payment payment); //写
    public Payment getPaymentById(Long id);  //读取
}
