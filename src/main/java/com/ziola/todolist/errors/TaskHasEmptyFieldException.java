package com.ziola.todolist.errors;

import lombok.Data;

@Data
public class TaskHasEmptyFieldException extends RuntimeException {

    private String message;

    public TaskHasEmptyFieldException(String message) {
        //super(message);
        this.message = message;
    }
}

