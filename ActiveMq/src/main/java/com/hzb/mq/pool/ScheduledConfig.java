package com.hzb.mq.pool;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 队列对象配置
 * 
 * @author hzb
 */
@Configuration
public class ScheduledConfig {

	@Bean
	public ActiveMQQueue queue() {
		return new ActiveMQQueue("promoteAct");
	}
}
