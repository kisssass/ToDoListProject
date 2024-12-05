package ru.kissass.ToDoListProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.kissass.ToDoListProject.service.TaskServiceImpl;

@Controller
public class HomeController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", taskService.getAll());
        return modelAndView;
    }

}