package com.hzb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //声明定时任务
public class ActiveMqPoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMqPoolApplication.class, args);
	}

}

