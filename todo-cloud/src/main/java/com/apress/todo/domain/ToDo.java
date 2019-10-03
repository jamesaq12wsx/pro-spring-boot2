package com.apress.todo.domain;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ToDo {

    private String id;

    private String description;

    private LocalDateTime created;

    private LocalDateTime modified;

    private boolean completed;

    public ToDo(){}

    public ToDo(String id, String description, LocalDateTime created, LocalDateTime modified, boolean completed) {
        this.id = id;
        this.description = description;
        this.created = created;
        this.modified = modified;
        this.completed = completed;
    }

    public ToDo(String description){
        this.description = description;
    }

    public ToDo(String description, boolean completed){

        this.description = description;

        this.completed = completed;
    }
}
