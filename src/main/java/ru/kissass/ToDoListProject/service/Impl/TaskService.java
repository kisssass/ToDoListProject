package ru.kissass.ToDoListProject.service.Impl;

import ru.kissass.ToDoListProject.entity.TodoItem;
import ru.kissass.ToDoListProject.entity.TaskStateEntity;

public interface TaskService {
    TodoItem findByName(String name);
    Iterable<TodoItem> getAll();
    void addTask(TodoItem task);
    void addTask(String name, String description, TaskStateEntity taskState);
    void deleteTaskByName(String name);
    void updateTask(String name, String newName, String newDescription, String newTaskState);

}