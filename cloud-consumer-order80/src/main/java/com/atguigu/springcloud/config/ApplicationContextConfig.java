package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced    //使用微服务名(可能存在多个微服务的提供者)访问时，必须开启负载均衡策略。
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
