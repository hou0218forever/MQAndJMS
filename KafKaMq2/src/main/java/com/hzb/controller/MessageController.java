package com.hzb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.hzb.kafka.KafkaProducer;

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
	KafkaProducer producer;

	@GetMapping("/send")
	public void send(String topic, String msg) {
		try {
			System.out.println(msg + "开始发出一次请求，时间是" + new Date());
			producer.send(topic, msg);
			System.out.println(msg + "请求发送完成，时间是" + new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@GetMapping("/sendList")
	public void sendList(String topic, String[]msgs) {
		try {
			List<String> list = Lists.newArrayList(msgs);
			System.out.println(list + "开始发出一次请求，时间是" + new Date());
			producer.send(topic, list);
			System.out.println(list + "请求发送完成，时间是" + new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
