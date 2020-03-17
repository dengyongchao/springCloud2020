package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHistrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "paymnet_Global_fallbackMethod")
public class OrderHistrixController {

    @Resource
    private PaymentHistrixService paymentHistrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id){
        return paymentHistrixService.paymentInfo_Ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1000")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        int n = 10/0;
        return paymentHistrixService.paymentInfo_Timeout(id);
    }

    public String paymentInfo_TimeoutHandler(Integer id){

        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeoutHandler,id:  +"+id+"\t"+"我消费端来兜底";
    }


    //全局fallback
    public String paymnet_Global_fallbackMethod(){
        return "全局异常出炉，请稍后再尝试";
    }

}
