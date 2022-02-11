package com.ziola.todolist.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class TaskToCreate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String taskName;
    private String description;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate endDate;
    @JsonFormat(pattern = "yyyy.MM.dd")
    private LocalDate startDate;
    private LocalTime endTime;
    private LocalTime startTime;
}
