package ru.kissass.ToDoListProject.service;

import org.springframework.stereotype.Service;
import ru.kissass.ToDoListProject.entity.CommentEntity;
import ru.kissass.ToDoListProject.entity.TodoItem;
import ru.kissass.ToDoListProject.repository.CommentRepository;
import ru.kissass.ToDoListProject.repository.TaskRepository;
import ru.kissass.ToDoListProject.service.Impl.CommentService;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    public CommentServiceImpl(CommentRepository commentRepository,
                              TaskRepository taskRepository)
    {
        this.commentRepository = commentRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void deleteCommentToTask(TodoItem task) {
        List<CommentEntity> comments = commentRepository.findByTask(task);
        commentRepository.deleteAll(comments);
        taskRepository.delete(task);
    }

    @Override
    public void moveCommentToTask(List<CommentEntity> comments, TodoItem task)
    {
        for(CommentEntity comment: comments)
        {
            CommentEntity newComment = new CommentEntity();
            newComment.setText(comment.getText());
            newComment.setTask(comment.getTask());
            newComment.setUser(comment.getUser());
            commentRepository.save(comment);
        }
    }
}