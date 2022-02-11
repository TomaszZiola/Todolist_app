package com.ziola.todolist.controllers;

import com.ziola.todolist.domain.TaskToCreate;
import com.ziola.todolist.errors.TaskEndDateBeforeNowException;
import com.ziola.todolist.errors.TaskHasEmptyFieldException;
import com.ziola.todolist.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping(value = "/addTask")
@RequiredArgsConstructor public class AddNewTaskController {

    private final TaskRepository taskRepository;

    @GetMapping
    public TaskToCreate addNewTask(@Valid @RequestBody TaskToCreate taskToCreate) {

        TaskToCreate taskCreated = validateJson(taskToCreate);
        taskRepository.save(taskCreated);

        return taskCreated;
    }

    private TaskToCreate validateJson(TaskToCreate taskToCreate) {
        if (taskToCreate.getTaskName().isBlank()) {
            throw new TaskHasEmptyFieldException("Task's name");
        } else if (taskToCreate.getEndDate().isBefore(LocalDate.now())) {
            throw new TaskEndDateBeforeNowException();
        } else if (taskToCreate.getEndTime().isBefore(LocalTime.now()) && taskToCreate.getEndDate().equals(LocalDate.now())) {
            throw new TaskEndDateBeforeNowException();
        }
        return taskToCreate;
    }
}
