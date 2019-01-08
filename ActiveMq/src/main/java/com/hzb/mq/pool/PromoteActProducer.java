package com.hzb.mq.pool;

import javax.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 消息队列发送端测试代码:
 * 
 * @author hzb
 */
@Component
public class PromoteActProducer {

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	private static int a = 1;

	@Scheduled(fixedDelay = 2000) // 每2s执行1次
	public void send() {
		a++;
		this.jmsMessagingTemplate.convertAndSend(queue, "消息生产端产生消息" + a);
	}
}
