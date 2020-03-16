package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.PaymentHistrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHistrixService {
    @Override
    public String paymentInfo_Ok(Integer id) {
        //服务降级逻辑
        return "-------paymentInfo_Ok paymentFallbackService fall back,";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-------paymentInfo_Timeout paymentFallbackService fall back,";
    }
}
