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
     * topic.message1 ������ topic.message3��
     * Ҳ����topic.message3��topic.message1 ���ᱻ Receiver1 @RabbitListener(queues = "topic.message1")�յ�
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage1, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage1).to(exchange).with("topic.message3");
    }

    /**
     * �����൱�� topic.message2 ������topic.*,����topic.��ͷ����Ϣ���ᱻ Receiver2  @RabbitListener(queues = "topic.message2") �յ�
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessage2, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage2).to(exchange).with("topic.#");
    }
}
