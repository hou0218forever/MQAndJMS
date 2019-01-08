package com.hzb.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hzb.mq.Producer;
import com.hzb.mq.Topic_Producer;

/**
 *
 * @author hzb
 * @create 2018-08-28 16:32
 **/
@RequestMapping("/MessageCenter")
@RestController
public class MessageController {

	// 创建一个生产者，消费者在系统运行时已经创建
	@Autowired
	Producer producer;

	@Autowired
	Topic_Producer topic_producer;

	@GetMapping("/SendMessageByQueue")
	public void send(String msg) {
		try {
			System.out.println(msg + "开始发出一次请求，时间是" + new Date());
			producer.sendMessage(msg);
			System.out.println(msg + "请求发送完成，时间是" + new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/SendMessageByTopic")
	public void sendTopic(String msg) {
		try {
			System.out.println(msg + "开始发出一次请求，时间是" + new Date());
			topic_producer.sendMessage(msg);
			System.out.println(msg + "请求发送完成，时间是" + new Date());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
