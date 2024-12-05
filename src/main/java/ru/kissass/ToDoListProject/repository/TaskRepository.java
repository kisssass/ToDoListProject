package ru.kissass.ToDoListProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import ru.kissass.ToDoListProject.entity.TodoItem;

@RepositoryRestResource
@Repository
public interface TaskRepository extends JpaRepository<TodoItem, Long> {
}