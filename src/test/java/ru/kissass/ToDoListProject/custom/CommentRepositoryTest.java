package ru.kissass.ToDoListProject.custom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kissass.ToDoListProject.entity.*;
import ru.kissass.ToDoListProject.repository.*;
import ru.kissass.ToDoListProject.utility.Role;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CommentRepositoryTest {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskStateRepository taskStateRepository;
    private TodoItem task;
    private UserEntity user1;
    private TaskStateEntity taskState;
    private ProjectEntity project;
    private CommentEntity comment1;
    private CommentEntity comment2;
    @Autowired
    CommentRepositoryTest(CommentRepository commentRepository,
                          TaskRepository taskRepository,
                          UserRepository userRepository,
                          ProjectRepository projectRepository,
                          TaskStateRepository taskStateRepository)
    {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.taskStateRepository = taskStateRepository;
    }

    @BeforeEach
    void setUp() {

        project = new ProjectEntity();
        project.setName(UUID.randomUUID().toString());
        projectRepository.save(project);

        user1 = new UserEntity();
        user1.setUserName(UUID.randomUUID().toString());
        user1.setEmail(UUID.randomUUID().toString());
        user1.setPassword(UUID.randomUUID().toString());
        user1.setFirsName(UUID.randomUUID().toString());
        user1.setLastName(UUID.randomUUID().toString());
        user1.setRoles(Set.of(Role.USER));
        userRepository.save(user1);

        taskState = new TaskStateEntity();
        taskState.setName(UUID.randomUUID().toString());
        taskState.setProject(project);
        taskStateRepository.save(taskState);

        task = new TodoItem();
        task.setName(UUID.randomUUID().toString());
        task.setDescription(UUID.randomUUID().toString());
        task.setTaskState(taskState);
        taskRepository.save(task);

        comment1 = new CommentEntity();
        comment1.setUser(user1);
        comment1.setTask(task);
        comment1.setText(UUID.randomUUID().toString());
        commentRepository.save(comment1);

        comment2 = new CommentEntity();
        comment2.setUser(user1);
        comment2.setTask(task);
        comment2.setText(UUID.randomUUID().toString());
        commentRepository.save(comment2);
    }

    @Test
    void testFindByTask() {
        List<CommentEntity> foundComments = commentRepository.findByTask(task);
        assertThat(foundComments).isNotEmpty();
        assertEquals(2, foundComments.size());
        assertThat(foundComments).anyMatch(comment -> comment.getText().equals(comment1.getText()));
        assertThat(foundComments).anyMatch(comment -> comment.getText().equals(comment2.getText()));
    }

    @Test
    void testFindByTaskAndUser() {
        List<CommentEntity> foundComments = commentRepository.findByTaskAndUser(task, user1);
        assertThat(foundComments).isNotEmpty();
        assertEquals(2, foundComments.size());
        assertThat(foundComments).anyMatch(comment -> comment.getText().equals(comment1.getText()));
        assertThat(foundComments).anyMatch(comment -> comment.getText().equals(comment2.getText()));

    }

}