package com.w2m.broker.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NaveEspacialConsumer {
      @RabbitListener(queues = "NaveEspacialQueue")
      public void receive(String message) {
          System.out.println("Received: " + message);
      }
}
