package com.apress.todo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Hold todo.jms.destination properties
 * indicate which queue/topic to connect
 *
 */
@Data
@ConfigurationProperties(prefix = "todo.jms")
public class ToDoProperties {

    private String destination;

}
