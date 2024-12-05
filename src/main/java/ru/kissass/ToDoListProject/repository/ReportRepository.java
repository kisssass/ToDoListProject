package ru.kissass.ToDoListProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.kissass.ToDoListProject.entity.ReportEntity;

@RepositoryRestResource
public interface ReportRepository extends CrudRepository<ReportEntity, Long>
{

}