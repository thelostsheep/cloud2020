package com.shlock.springcloud.controller;/*
    @author Shlock
    @create date 2020-07-11 19:05    
*/


import com.shlock.springcloud.entities.CommonResult;
import com.shlock.springcloud.entities.Payment;
import com.shlock.springcloud.servier.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;  //调用远程的微服接口

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
}
