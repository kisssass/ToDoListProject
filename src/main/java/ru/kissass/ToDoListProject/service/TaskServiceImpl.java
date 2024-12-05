package ru.kissass.ToDoListProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kissass.ToDoListProject.entity.TodoItem;
import ru.kissass.ToDoListProject.repository.TaskRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class TaskServiceImpl {

    @Autowired
    private TaskRepository taskRepository;

    public Optional<TodoItem> getById(Long id) {
        return taskRepository.findById(id);
    }

    public Iterable<TodoItem> getAll() {
        return taskRepository.findAll();
    }

    public TodoItem save(TodoItem todoItem) {
        if (todoItem.getId() == null) {
            todoItem.setCreatedAt(createDate());
        }
        todoItem.setUpdatedAt(createDate());
        return taskRepository.save(todoItem);
    }

    public void delete(TodoItem todoItem) {
        taskRepository.delete(todoItem);
    }

    public String createDate() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formattedDateTime = currentDateTime.format(formatter);

        return formattedDateTime;
    }

}