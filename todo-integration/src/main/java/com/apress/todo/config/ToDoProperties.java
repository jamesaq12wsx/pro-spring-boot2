package com.apress.todo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "tmp")
public class ToDoProperties {

    private String directory;
    private String filePattern;

}
