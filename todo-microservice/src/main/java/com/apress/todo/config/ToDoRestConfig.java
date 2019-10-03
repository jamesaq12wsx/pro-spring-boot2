package com.apress.todo.config;

import com.apress.todo.domain.ToDo;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

public class ToDoRestConfig extends RepositoryRestConfigurerAdapter {

    /**
     * This config let repository show id
     *
     * @param config
     */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(ToDo.class);
    }

}
