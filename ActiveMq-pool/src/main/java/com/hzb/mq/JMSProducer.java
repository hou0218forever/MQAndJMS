package com.hzb.mq;

import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * 消息队列发送端测试代码:
 * 
 * @author hzb
 */
@Component
public class JMSProducer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(Destination destination,String message) {
        this.jmsTemplate.convertAndSend(destination,message);
    }
}
