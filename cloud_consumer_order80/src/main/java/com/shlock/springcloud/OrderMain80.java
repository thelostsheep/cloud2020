package com.shlock.springcloud;/*
    @author Shlock
    @create date 2020-07-10 21:04    
*/

import com.shlock.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@EnableEurekaClient
@SpringBootApplication
//ribbon客户端对那个服务进行负载均衡，采用那种负载均衡策略
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
