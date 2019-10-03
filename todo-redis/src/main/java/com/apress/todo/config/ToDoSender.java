package com.apress.todo.config;

import com.apress.todo.domain.ToDo;
import com.apress.todo.redis.ToDoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@Configuration
public class ToDoSender {

    @Autowired
    private ToDoProducer producer;

    @Value("${todo.redis.topic}")
    private String destination;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 10000L)
    private void sendToDos(){
        producer.sendTo(destination,new ToDo("Thinking on Spring Boot at "
                + dateFormat.format(new Date())));
    }

}
