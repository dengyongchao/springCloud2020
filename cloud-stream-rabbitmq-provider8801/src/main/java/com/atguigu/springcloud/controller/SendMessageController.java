package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.ImessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController {

    @Resource
    private ImessageProvider imessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return imessageProvider.send();
    }

}
