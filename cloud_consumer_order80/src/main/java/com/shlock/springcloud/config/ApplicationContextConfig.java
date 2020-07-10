package com.shlock.springcloud.config;/*
    @author Shlock
    @create date 2020-07-10 21:12    
*/

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@Configuration  spring提供的
@SpringBootConfiguration //springboot提供的，用来声明一个配置类。代替了@Configuration
public class ApplicationContextConfig {
    //在IOC容器中声明一个bean对象
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
