package com.shlock.springcloud.service;/*
    @author Shlock
    @create date 2020-07-12 11:12    
*/

public interface PaymentService {
    public String paymentInfo_OK(Integer id);
    public String payment_Timeout(Integer id);

    public String paymentCircuitBreaker(Integer id);
}
