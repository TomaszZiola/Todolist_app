package com.ziola.todolist.repository;

import com.ziola.todolist.domain.TaskToCreate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskToCreate, Long> {
}
