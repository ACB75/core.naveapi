package com.w2m.broker.rabbitmq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.impl.AMQImpl.Queue;

@Configuration
public class RabbitMQConf {
    @Bean
    Queue queue() {
            return new Queue();
      }
}