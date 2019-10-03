package com.apress.todo.config;

import com.apress.todo.domain.ToDo;
import com.apress.todo.jms.ToDoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

//@EnableScheduling
//@Configuration
public class ToDoSender {

//    @Bean
//    public CommandLineRunner sendToDos(@Value("${todo.amqp.queue}") String queue, ToDoProducer producer){
//        return args -> {
//
//
//            int i=0;
//            while (true){
//                producer.sendTo(queue,new ToDo("workout " + i + " tomorrow morning!"));
//
//                i++;
//            }
//        };
//    }

    @Autowired
    private ToDoProducer producer;

    @Value("${todo.amqp.queue}")
    private String destination;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 500L)
    private void sendToDos(){
        producer.sendTo(destination,new ToDo("Thinking on Spring Boot at "
                + dateFormat.format(new Date())));
    }

}
