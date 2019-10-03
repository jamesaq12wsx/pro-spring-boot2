package com.apress.todo.integration;

import com.apress.todo.domain.ToDo;
import org.slf4j.*;
import org.springframework.stereotype.Component;

@Component
public class ToDoMessageHandler {
    private Logger log = LoggerFactory.getLogger(ToDoMessageHandler.class);
    public void process(ToDo todo){
        log.info(">>> {}", todo);
// More process...
    }
}