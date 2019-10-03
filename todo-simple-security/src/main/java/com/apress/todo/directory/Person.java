package com.apress.todo.directory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)        // ignore properties not define... ex: birthday
public class Person {

    private String email;

    private String password;

    private String role;

    private boolean enabled;
}
