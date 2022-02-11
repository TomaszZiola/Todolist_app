package com.ziola.todolist.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TaskHandler {

    @ExceptionHandler(TaskHasEmptyFieldException.class)
    public ResponseEntity<ErrorTask> taskHasEmptyFields(TaskHasEmptyFieldException e) {
        ErrorTask errorTask = new ErrorTask("Field '" + e.getMessage() + "', cannot be empty!");
        return new ResponseEntity<>(errorTask, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TaskEndDateBeforeNowException.class)
    public ResponseEntity<ErrorTask> taskHasEmptyFields() {
        ErrorTask errorTask = new ErrorTask("The end time cannot be before the current time!");
        return new ResponseEntity<>(errorTask, HttpStatus.BAD_REQUEST);
    }
}
