package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.ImessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)   //定义消息的推送管道
public class MessageProviderImpl implements ImessageProvider {

    @Resource
    private MessageChannel output;   //消息发送管道

    @Override
    public String send() {
        String string = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(string).build());
        return null;
    }
}
