package ru.kissass.ToDoListProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kissass.ToDoListProject.utility.Role;
import ru.kissass.ToDoListProject.entity.UserEntity;
import ru.kissass.ToDoListProject.repository.ProjectRepository;
import ru.kissass.ToDoListProject.repository.TaskRepository;
import ru.kissass.ToDoListProject.service.UserServiceImpl;

import java.util.Set;

@Controller
@RequestMapping()
public class MainController {

    private final UserServiceImpl userService;
    //private final TaskRepository taskRepository;
    //private final ProjectRepository projectRepository;

    @Autowired
    public MainController(UserServiceImpl userService,
                          TaskRepository taskRepository,
                          ProjectRepository projectRepository) {
        this.userService = userService;
        //this.taskRepository = taskRepository;
        //this.projectRepository = projectRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Ссылка на login.html в папке templates
    }

    @GetMapping("/registration")
    public String getRegistration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(UserEntity user, Model model)
    {
        user.setRoles(Set.of(Role.USER));
        userService.addUser(user);
        model.addAttribute("message", "Регистрация прошла успешно! Теперь вы можете войти.");
        return "login";
    }

    /*@GetMapping("/home")
    public String home()
    {
        return "home";
    }

    @GetMapping("/task/list")
    public String taskListView(Model model) {
        Iterable<TaskEntity> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "taskList";
    }*/
}