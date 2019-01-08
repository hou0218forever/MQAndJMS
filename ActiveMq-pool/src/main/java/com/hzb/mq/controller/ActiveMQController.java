package com.hzb.mq.controller;

import javax.jms.Queue;
import javax.jms.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzb.mq.JMSProducer;
@RequestMapping("/activemq")
@RestController
@EnableAutoConfiguration
public class ActiveMQController {

	@Autowired
	private JMSProducer jmsProducer;

//    public void testJms() {
//        Destination destination = new ActiveMQQueue("springboot.queue.test");
//
//        for (int i=0;i<10;i++) {
//            jmsProducer.sendMessage(destination,"hello,world!" + i);
//        }
//    }
	@Autowired
	private Topic topic;
	@Autowired
	private Queue queue;

	@RequestMapping("/queue")
	public String queue() {
		for (int i = 0; i < 10; i++) {
			jmsProducer.sendMessage(queue, "queue,world!" + i);
		}
		return "success";
	}

	@RequestMapping("/topic")
	public String topic() {
		for (int i = 0; i < 10; i++) {
			jmsProducer.sendMessage(topic, "topic,world!" + i);
		}
		return "success";
	}
}
