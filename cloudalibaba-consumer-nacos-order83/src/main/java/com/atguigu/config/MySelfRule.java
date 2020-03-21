package com.atguigu.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }

}
