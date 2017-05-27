package com.didispace.rabbit.topicexchange;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hi, i am message all";
		System.err.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.99", context);
	}

	public void sendA() {
		String context = "hi, i am message all";
		System.err.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.dsfdsfsdfdsf", context);
	}

	public void send1() {
		String context = "hi, i am message 1";
		System.err.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message1", context);
	}

	public void send2() {
		String context = "hi, i am messages 2";
		System.err.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message2", context);
	}

	public void send3() {
		String context = "hi, i am messages 2";
		System.err.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message3", context);
	}

}