package com.shlock.springcloud;/*
    @author Shlock
    @create date 2020-07-10 13:12    
*/

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.shlock.springcloud.dao")
@SpringBootApplication
public class Payment8001 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8001.class,args);
    }
}
