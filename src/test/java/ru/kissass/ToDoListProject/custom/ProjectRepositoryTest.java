package ru.kissass.ToDoListProject.custom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kissass.ToDoListProject.entity.ProjectEntity;
import ru.kissass.ToDoListProject.repository.ProjectRepository;

import java.util.UUID;

@SpringBootTest
public class ProjectRepositoryTest {
    private final ProjectRepository projectRepository;

    @Autowired
    ProjectRepositoryTest(ProjectRepository projectRepository)
    {
        this.projectRepository = projectRepository;
    }

    @Test
    void testFindProjectByName()
    {
        String projectName = UUID.randomUUID().toString();
        ProjectEntity project = new ProjectEntity();

        project.setName(projectName);
        projectRepository.save(project);

        ProjectEntity fondProject = projectRepository.findByName(projectName).getFirst();

        Assertions.assertNotNull(fondProject);
        Assertions.assertEquals(project.getId(), fondProject.getId());
        Assertions.assertEquals(project.getName(), fondProject.getName());
    }
}