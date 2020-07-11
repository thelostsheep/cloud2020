package com.shlock.springcloud.lb;/*
    @author Shlock
    @create date 2020-07-11 17:25    
*/

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {
    //收集服务器总共有多少台能够提供服务的机器，并放到list里面
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
