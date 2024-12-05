package ru.kissass.ToDoListProject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.kissass.ToDoListProject.entity.UserEntity;

@RepositoryRestResource(path = "users")
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    //UserEntity findById(long id);
    UserEntity findByEmail(String email);
    //List<UserEntity> findByEmail(String email);
    //List<UserEntity> findByFirsNameAndLastName(String FirstName, String lastName);
}