package com.core.naveapi.broker;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.core.naveapi.config.RabbitMQConfig;

@Component
public class RabbitMQConsumer {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

	
	@RabbitListener(queues = RabbitMQConfig.QUEUE)
	public void getMsg(String msg) {
		logger.warn("RabbitMQ - getMsg: {}", msg);
	}
}
