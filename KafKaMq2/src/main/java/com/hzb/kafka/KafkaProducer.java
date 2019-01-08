package com.hzb.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hzb
 * @version 2017/9/1 下午05:03
 */
@Component
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	/**
	 * 向topic中发送消息
	 */
	public void send(String topic, String msg) {
		kafkaTemplate.send(topic, msg);
	}

	/**
	 * 向topic中发送消息
	 */
	public void send(String topic, List<String> msgs) {
		msgs.forEach(msg -> kafkaTemplate.send(topic, msg));
	}
}
