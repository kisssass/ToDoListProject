package ru.kissass.ToDoListProject.controller.RestController;

/*
@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskStateRepository taskStateRepository;
    private final TaskServiceImpl taskService;
    @Autowired
    public TaskController(TaskStateRepository taskStateRepository,
                          TaskServiceImpl taskService) {
        this.taskStateRepository = taskStateRepository;
        this.taskService = taskService;
    }

    @GetMapping("/findByName")
    public TaskEntity findByName(@RequestParam String name)
    {
        return taskService.findByName(name);
    }

    @PostMapping("/addTask")
    public void addTask(@RequestParam
                        String nameTask,
                        String description,
                        String nameTaskState)
    {
        TaskStateEntity taskState = taskStateRepository.findByName(nameTaskState).getFirst();
        taskService.addTask(nameTask, description, taskState);

    }

    @DeleteMapping("/deleteTask")
    public void deleteTask(@RequestParam String name)
    {
        taskService.deleteTaskByName(name);
    }

    @PutMapping("/PutTask")
    public void updateTask(@RequestParam String oldName, String newName,
                           String newDescription, String newTaskState)
    {
        taskService.updateTask(oldName, newName, newDescription, newTaskState);
    }

}
*/