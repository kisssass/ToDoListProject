package ru.kissass.ToDoListProject.custom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kissass.ToDoListProject.utility.Role;
import ru.kissass.ToDoListProject.entity.UserEntity;
import ru.kissass.ToDoListProject.repository.UserRepository;

import java.util.Set;
import java.util.UUID;

@SpringBootTest
public class UserRepositoryTest {

    private final UserRepository userRepository;

    private UserEntity user1;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @BeforeEach
    void setUo() {
        user1 = new UserEntity();
        user1.setUserName(UUID.randomUUID().toString());
        user1.setEmail(UUID.randomUUID().toString());
        user1.setPassword(UUID.randomUUID().toString());
        user1.setFirsName(UUID.randomUUID().toString());
        user1.setLastName(UUID.randomUUID().toString());
        user1.setRoles(Set.of(Role.USER));
        userRepository.save(user1);
    }

    @Test
    void testFindByUserName()
    {
        UserEntity foundUser = userRepository.findByUserName(user1.getUserName());
        Assertions.assertNotNull(foundUser);
    }

}