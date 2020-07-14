package com.shlock.springcloud.service.impl;/*
    @author Shlock
    @create date 2020-07-14 21:30    
*/

import com.shlock.springcloud.entities.CommonResult;
import com.shlock.springcloud.entities.Payment;
import com.shlock.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return new CommonResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}