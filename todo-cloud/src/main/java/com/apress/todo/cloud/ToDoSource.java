package com.apress.todo.cloud;

import com.apress.todo.domain.ToDo;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

//@EnableBinding(Source.class)
public class ToDoSource {

    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT, poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "2"))
    public MessageSource<ToDo> simpleToDo(){
        return () -> MessageBuilder
                .withPayload(new ToDo("Test Spring Cloud Stream"))
                .build();
    }

}
