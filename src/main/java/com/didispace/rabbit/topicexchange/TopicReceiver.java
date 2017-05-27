package com.didispace.rabbit.topicexchange;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message1")
public class TopicReceiver {

    @RabbitHandler
    public void process(String message) {
        System.err.println("Topic Receiver1  : " + message);
    }

}
