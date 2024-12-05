package ru.kissass.ToDoListProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.kissass.ToDoListProject.entity.CommentEntity;
import ru.kissass.ToDoListProject.entity.TodoItem;
import ru.kissass.ToDoListProject.entity.UserEntity;

import java.util.List;

@RepositoryRestResource(path = "comment")
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
    List<CommentEntity> findByTask(TodoItem task);
    List<CommentEntity> findByTaskAndUser(TodoItem task, UserEntity user);

}