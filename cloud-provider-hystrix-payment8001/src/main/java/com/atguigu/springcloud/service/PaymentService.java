package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id){
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_Ok,id:  +"+id+"\t"+"哈哈";
    }

    /**
     * //如果发生异常，自动调用fallback方法
     * 正常访问
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id){
        //int n = 1/0;
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception  e){
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_Timeout,id:  +"+id+"\t"+"哈哈";
    }

    public String paymentInfo_TimeoutHandler(Integer id){

        return "线程池："+Thread.currentThread().getName()+"   paymentInfo_TimeoutHandler,id:  +"+id+"\t"+"我来兜底";
    }


}
