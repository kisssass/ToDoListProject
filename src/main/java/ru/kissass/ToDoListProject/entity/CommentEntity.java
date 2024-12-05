package ru.kissass.ToDoListProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Instant createdAt = Instant.now();

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TodoItem task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}