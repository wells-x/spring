package com.wells.common.kit.util;

import com.aliyun.openservices.ons.api.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Properties;
import java.util.function.Supplier;

@Component
public class MsgUtil {

    public static MsgUtil me = SpringContextHolder.getBean(MsgUtil.class);

    @Value("${AccessKeyID}")
    private static String accessKey;

    @Value("${AccessKeySecret}")
    private static String secretKey;

    @Value("${SendMsgTimeoutMillis}")
    private static String sendMsgTimeoutMillis;

    @Value("${ONSAddr}")
    private static String onsAddr;

    private static Producer producer;

    private static Consumer consumer;

    static {
        Properties properties = new Properties();
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey, accessKey);
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, secretKey);
        //设置发送超时时间，单位毫秒
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, sendMsgTimeoutMillis);
        // 设置 TCP 接入域名（此处以公共云生产环境为例）
        properties.put(PropertyKeyConst.ONSAddr, onsAddr);
        producer = ONSFactory.createProducer(properties);
        // 在发送消息前，必须调用 start 方法来启动 Producer，只需调用一次即可
        producer.start();
        consumer = ONSFactory.createConsumer(properties);
        // 广播订阅方式
        properties.put(PropertyKeyConst.MessageModel, PropertyValueConst.BROADCASTING);
    }

    public SendResult sendMsg(String key, String tag, String message) {
        Message msg = new Message(
                // Message 所属的 Topic
                "jtj-service",
                // Message Tag 可理解为 Gmail 中的标签，对消息进行再归类，方便 Consumer 指定过滤条件在 MQ 服务器过滤
                tag,
                // Message Body 可以是任何二进制形式的数据， MQ 不做任何干预，
                // 需要 Producer 与 Consumer 协商好一致的序列化和反序列化方式
                message.getBytes());
        // 设置代表消息的业务关键属性，请尽可能全局唯一。
        // 以方便您在无法正常收到消息情况下，可通过阿里云服务器管理控制台查询消息并补发
        // 注意：不设置也不会影响消息正常收发
        msg.setKey(key);
        return producer.send(msg);
    }

    public void sub(String tag, Supplier supplier) {
        //订阅多个 Tag
        consumer.subscribe("jtj-service", "tag", (message, context) -> {
            supplier.get();
            return Action.CommitMessage;
        });
        consumer.start();
    }


}
