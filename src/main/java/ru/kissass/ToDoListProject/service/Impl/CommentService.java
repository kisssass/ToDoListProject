package ru.kissass.ToDoListProject.service.Impl;

import ru.kissass.ToDoListProject.entity.CommentEntity;
import ru.kissass.ToDoListProject.entity.TodoItem;

import java.util.List;

public interface CommentService {
    void deleteCommentToTask(TodoItem task);
    void moveCommentToTask(List<CommentEntity>comments,  TodoItem task);
}