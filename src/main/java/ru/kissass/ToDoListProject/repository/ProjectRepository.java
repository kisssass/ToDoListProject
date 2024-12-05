package ru.kissass.ToDoListProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.kissass.ToDoListProject.entity.ProjectEntity;

import java.util.List;

@RepositoryRestResource(path = "project")
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long> {
    List<ProjectEntity> findByName(String name);

}