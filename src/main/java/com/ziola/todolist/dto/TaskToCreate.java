package com.ziola.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class TaskToCreate {

    private String taskName;
    private LocalDate endDate;
    private LocalDate startDate;
    private LocalTime endTime;
    private LocalTime startTime;
}
