package com.core.naveapi.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	public static final String QUEUE = "naves_queue";
	public static final String EXCHANGE = "naves_exchange";
	public static final String ROUTING_KEY = "naves_routingKey";

    @Bean
    Queue queue() {
		return new Queue(QUEUE);
	}

    @Bean
    TopicExchange exchange() {
		return new TopicExchange(EXCHANGE);
	}

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	}
}
