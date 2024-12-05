package ru.kissass.ToDoListProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.kissass.ToDoListProject.entity.ProjectEntity;
import ru.kissass.ToDoListProject.entity.TaskStateEntity;

import java.util.List;

@RepositoryRestResource(path = "taskState")
public interface TaskStateRepository extends CrudRepository<TaskStateEntity, Long> {
    List<TaskStateEntity> findByProject(ProjectEntity project);
    List<TaskStateEntity> findByName(String name);
}