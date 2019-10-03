package com.apress.todo.error;

import org.slf4j.*;
import org.springframework.util.ErrorHandler;

public class ToDoErrorHandler implements ErrorHandler {

    private static Logger log = LoggerFactory.getLogger(ToDoErrorHandler.class);

    @Override
    public void handleError(Throwable t) {

        log.warn("ToDo error...");
        log.error(t.getCause().getMessage());
    }

}
