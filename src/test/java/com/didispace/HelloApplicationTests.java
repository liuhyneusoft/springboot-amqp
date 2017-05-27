package com.didispace;

import com.didispace.rabbit.sendreceive.Sender;
import com.didispace.rabbit.subscribe.SubSender;
import com.didispace.rabbit.topicexchange.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = HelloApplication.class)
public class HelloApplicationTests {

	@Autowired
	private Sender sender;

	@Autowired
	private SubSender subSender;

	@Autowired
	private TopicSender topicSender;


	@Test
	public void test() throws Exception {
		//sendReceivePointToPoint();

		//sendReceiveSubscribe();

		//sendReceiveTopicExchange();
	}

	public void sendReceiveSubscribe(){
		subSender.send();
	}

	public void sendReceiveTopicExchange(){
		subSender.send();
	}

	public void sendReceivePointToPoint(){
		sender.send();
		//sender.sendMany();
	}

}
