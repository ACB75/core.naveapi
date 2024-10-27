package com.core.naveapi.broker;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.naveapi.config.RabbitMQConfig;

@Service
public class RabbitMQProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void enviarMensaje(String mensaje) {
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, mensaje);
	}
}
