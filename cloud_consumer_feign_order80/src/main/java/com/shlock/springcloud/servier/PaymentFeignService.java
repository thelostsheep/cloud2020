package com.shlock.springcloud.servier;/*
    @author Shlock
    @create date 2020-07-11 19:03    
*/

import com.shlock.springcloud.entities.CommonResult;
import com.shlock.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment);
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB();
}
