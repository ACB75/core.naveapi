package com.w2m.broker.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaveEspacialProducer {
      @Autowired
      private AmqpTemplate amqpTemplate;

      public void send(String message) {
          amqpTemplate.convertAndSend("NaveEspacialQueue", message);
      }
}
