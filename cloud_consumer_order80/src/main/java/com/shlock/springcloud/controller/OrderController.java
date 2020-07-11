package com.shlock.springcloud.controller;/*
    @author Shlock
    @create date 2020-07-10 21:13    
*/

import com.shlock.springcloud.entities.CommonResult;
import com.shlock.springcloud.entities.Payment;
import com.shlock.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    //服务发现客户端
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;
    //private String url = "http://localhost:8001/payment";
    private String url = "http://CLOUD-PAYMENT-SERVICE/payment";
    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(url + "/create", payment, CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(url + "/get/" + id, CommonResult.class);
    }
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        //通过自定义的负载均衡调用远程的服务实例
        //通过服务名获取服务集合
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        //判断是否获取到
        if(instances==null||instances.size()<=0) return null;
        //通过自定义的负载均衡策略来获取到服务实例
        ServiceInstance server = loadBalancer.instances(instances);
        //通过服务实例获取url
        URI uri = server.getUri();
        //调用url实现远程调用
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
