package com.hzb.mq.test;

import javax.jms.Queue;
import javax.jms.Topic;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hzb.mq.JMSProducer;

public class JmsTest extends BaseTest {
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

	@Test
	public void testJms() {
		for (int i = 0; i < 10; i++) {
			jmsProducer.sendMessage(queue, "queue,world!" + i);
			jmsProducer.sendMessage(topic, "topic,world!" + i);
		}
	}
}
