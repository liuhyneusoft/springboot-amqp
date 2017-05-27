package com.didispace.rabbit.sendreceive.config;

import com.didispace.rabbit.bean.User;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("helloObject");
    }

    /**
     * 类中使用了Bean注解的方法都会在初始化时执行执行，
     * 就好像xml中配置的bean会在容器启动时实例化
     */
    @Bean
    public User helloQueue1() {
        System.err.println("configuration 类中使用了Bean注解的方法都会在初始化时执行执行么？");
        return new User();
    }

}


