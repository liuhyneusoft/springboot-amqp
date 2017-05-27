package com.didispace.rabbit.topicexchange;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class TopicRabbitConfig {

    final static String message1  = "topic.message1";
    final static String message2  = "topic.message2";

    @Bean
    public Queue queueMessage1() {
        return new Queue(TopicRabbitConfig.message1);
    }

    @Bean
    public Queue queueMessage2() {
        return new Queue(TopicRabbitConfig.message2);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    /**
     * topic.message1 交换了 topic.message3，
     * 也就是topic.message3和topic.message1 都会被 Receiver1 @RabbitListener(queues = "topic.message1")收到
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage1, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.message3");
    }

    /**
     * 这里相当于 topic.message2 交换了topic.*,所有topic.开头的消息都会被 Receiver2  @RabbitListener(queues = "topic.message2") 收到
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessage2, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.#");
    }
}
