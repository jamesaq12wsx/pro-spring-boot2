package com.apress.todo.jms;

import com.apress.todo.domain.ToDo;
import com.apress.todo.repository.ToDoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class ToDoConsumer {

    private Logger log = LoggerFactory.getLogger(ToDoConsumer.class);

    private ToDoRepository repository;

    public ToDoConsumer(ToDoRepository repository){
        this.repository = repository;
    }

    /**
     * Process any message from queue
     *
     * @param todo
     */
    @RabbitListener(queues = "${todo.amqp.queue}")
    public void processToDo(@Valid ToDo todo){
        log.info("Consumer> " + todo);
        log.info("ToDo created> " + this.repository.save(todo));
    }
}
