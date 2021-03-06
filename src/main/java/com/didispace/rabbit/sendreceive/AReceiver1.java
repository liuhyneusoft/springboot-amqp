package com.didispace.rabbit.sendreceive;

import com.didispace.rabbit.entiry.TestObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "helloObject")
public class AReceiver1 {
    /**
     * 定义多个 Receiver，监听同一个Queue，那么消息会均匀的分配给这些Receiver
     */
    @RabbitHandler
    public void process(TestObject hello) {
        System.err.println("Receiver2222222222222 : " + hello.getName()+hello.getAge());
    }

}
