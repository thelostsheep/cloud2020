package com.shlock.springcloud.dao;/*
    @author Shlock
    @create date 2020-07-10 13:21    
*/

import com.shlock.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

//@Component       //代替@Repository声明bean
//@Mapper               //mybatis提供的，等价：@MapperScan("com.atguigu.springcloud.dao")
//@Repository     //spring提供的。在此，只是为了声明bean对象
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
