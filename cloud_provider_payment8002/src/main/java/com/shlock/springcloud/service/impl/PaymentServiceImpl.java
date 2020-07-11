package com.shlock.springcloud.service.impl;/*
    @author Shlock
    @create date 2020-07-10 13:26    
*/

import com.shlock.springcloud.dao.PaymentDao;
import com.shlock.springcloud.entities.Payment;
import com.shlock.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    //因为加Autowired会导致报错，所以这边选择jdk提供的注解
    @Resource  //先byName再byType
    //@Autowired   //先byType在byName
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById( Long id){
        return paymentDao.getPaymentById(id);
    }
}
