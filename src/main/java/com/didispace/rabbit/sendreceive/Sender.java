package com.didispace.rabbit.sendreceive;

import com.didispace.rabbit.entiry.TestObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender  {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String strDate = new Date().toString();
		String hi = "hi";
		System.err.println("Sender : " + hi+strDate);
		this.rabbitTemplate.convertAndSend("helloObject", new TestObject(hi,strDate));
	}


	public void sendMany() {
		String strDate = new Date().toString();
		String hi = "hi";
		System.err.println("Sender : " + hi + strDate);
		for(int i=0;i<20;i++) {
			this.rabbitTemplate.convertAndSend("helloObject", new TestObject(hi, strDate));
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}