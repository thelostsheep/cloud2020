package com.shlock.springcloud.controller;/*
    @author Shlock
    @create date 2020-07-10 13:27    
*/

import com.shlock.springcloud.entities.CommonResult;
import com.shlock.springcloud.entities.Payment;
import com.shlock.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 支持微服务接口开发：
 * 1.我们是服务提供者，是被其他微服务调用的。
 * 2.我们采用CommonResult封装返回结果。这个是统一化标准。项目要求。可以自定义状态码（码表）。
 * 3.服务提供者往往是需要连接数据库的
 * 4.服务提供者一般是不进行视图解析的。而是将数据转换为json（SpringMVC框架默认集成Jackson组件），直接返回给消费者服务。
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    //服务于服务之间远程调用，传递bean对象时，需要使用@RequestBody注解，从请求体中获取数据。
    //微服务工程的服务接口：提供是保存服务功能。
    @PostMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment){
        CommonResult<Payment> cResult = new CommonResult<>();
        try {
            int result = paymentService.create(payment);
            if (result == 0) {
                cResult.setCode(401);
                cResult.setMessage("插入数据库失败");
                cResult.setData(null);
                log.info("插入失败");
                return cResult;
            } else {
                cResult.setCode(200);
                cResult.setMessage("添加数据成功");
                cResult.setData(payment);

                log.debug("添加数据成功");
                return cResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
            cResult.setCode(500);
            cResult.setMessage("添加数据异常:" + e.getMessage());
            cResult.setData(null);
            log.debug("添加数据异常");
            return cResult;
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        CommonResult<Payment> result = new CommonResult<Payment>();
        result.setCode(200);
        result.setMessage("查询成功");
        result.setData(payment);
        log.debug("查询成功");
        return result ; //SpringMVC框架根据HttpMessageConverter，将Bean对象序列化为json串
    }
}
