package ru.kissass.ToDoListProject;

/*@SpringBootTest
public class TaskServiceTest {
    private final TaskRepository taskRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TaskStateRepository taskStateRepository;
    private final ProjectRepository projectRepository;
    private final TaskServiceImpl taskService;


    private TaskStateEntity taskState1;
    private TodoItem task1;
    private TodoItem task2;

    @Autowired
    public TaskServiceTest(TaskRepository taskRepository,
                           CommentRepository commentRepository,
                           UserRepository userRepository,
                           TaskStateRepository taskStateRepository,
                           ProjectRepository projectRepository,
                           TaskServiceImpl taskService)
    {
        this.taskRepository = taskRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.taskStateRepository = taskStateRepository;
        this.projectRepository = projectRepository;
        this.taskService = taskService;
    }

    @BeforeEach
    void setUp()
    {
        ProjectEntity project = new ProjectEntity();
        project.setName(UUID.randomUUID().toString());
        projectRepository.save(project);

        UserEntity user = new UserEntity();
        user.setUserName(UUID.randomUUID().toString());
        user.setFirsName(UUID.randomUUID().toString());
        user.setLastName(UUID.randomUUID().toString());
        user.setEmail(UUID.randomUUID().toString());
        user.setPassword(UUID.randomUUID().toString());
        user.setRoles(Set.of(Role.USER));
        userRepository.save(user);

        taskState1 = new TaskStateEntity();
        taskState1.setName(UUID.randomUUID().toString());
        taskState1.setProject(project);
        taskStateRepository.save(taskState1);

        task1 = new TodoItem();
        task1.setName(UUID.randomUUID().toString());
        task1.setDescription(UUID.randomUUID().toString());
        task1.setTaskState(taskState1);
        taskRepository.save(task1);

        task2 = new TodoItem();
        task2.setName(UUID.randomUUID().toString());
        task2.setDescription(UUID.randomUUID().toString());
        task2.setTaskState(taskState1);
        taskRepository.save(task2);

        CommentEntity comment1 = new CommentEntity();
        comment1.setUser(user);
        comment1.setTask(task1);
        comment1.setText(UUID.randomUUID().toString());
        commentRepository.save(comment1);

        CommentEntity comment2 = new CommentEntity();
        comment2.setUser(user);
        comment2.setTask(task1);
        comment2.setText(UUID.randomUUID().toString());
        commentRepository.save(comment2);

        CommentEntity comment3 = new CommentEntity();
        comment3.setUser(user);
        comment3.setTask(task2);
        comment3.setText(UUID.randomUUID().toString());
        commentRepository.save(comment3);
    }

    @Test
    void testDeleteTaskByName()
    {
        taskService.deleteTaskByName(task1.getName());
        Assertions.assertTrue(taskRepository.findByName(task1.getName()).isEmpty());;
        Assertions.assertTrue(commentRepository.findByTask(task1).isEmpty());
        Assertions.assertFalse(commentRepository.findByTask(task2).isEmpty());
    }

    @Test
    void testAddTask()
    {
        String name = UUID.randomUUID().toString();
        String description = "jfejwiotr";
        TaskStateEntity taskState = taskStateRepository.findByName(taskState1.getName()).getFirst();
        taskService.addTask(name, description, taskState);

        Assertions.assertNotNull(taskRepository.findByName(name));
    }

    @Test
    void testUpdateTask()
    {
        TodoItem task = new TodoItem();
        task.setName(UUID.randomUUID().toString());
        task.setDescription(UUID.randomUUID().toString());
        task.setTaskState(taskState1);
        taskRepository.save(task);

        String name = task.getName();
        String newName = UUID.randomUUID().toString();
        String newDescription = UUID.randomUUID().toString();
        String taskState = task.getTaskState().getName();

        taskService.updateTask(name, newName, newDescription, taskState);


    }
}*/