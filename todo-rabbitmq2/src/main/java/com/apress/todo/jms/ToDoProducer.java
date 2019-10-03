package com.apress.todo.jms;

import com.apress.todo.domain.ToDo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class ToDoProducer {

    private static final Logger log = LoggerFactory.getLogger(ToDoProducer.class);

    private RabbitTemplate rabbitTemplate;

    public ToDoProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendTo(String queue, ToDo toDo) {

        // send with routing key
        this.rabbitTemplate.convertAndSend(queue, toDo);

        log.info("Producer> Message Sent: " + toDo);
    }

}
