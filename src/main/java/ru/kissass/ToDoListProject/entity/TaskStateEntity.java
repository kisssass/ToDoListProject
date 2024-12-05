package ru.kissass.ToDoListProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@Entity
@Table(name = "task_state")
public class TaskStateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private Long ordinal;

    private Instant createdAt = Instant.now();

//    @OneToMany(mappedBy = "taskState")
//    private List<TaskEntity> task = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private ProjectEntity project;

}