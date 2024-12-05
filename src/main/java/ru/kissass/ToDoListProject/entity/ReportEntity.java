package ru.kissass.ToDoListProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.kissass.ToDoListProject.utility.ReportStatus;


@Setter
@Getter
@Entity
@Table(name = "report")
public class ReportEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReportStatus status = ReportStatus.CREATED;

    @Lob
    private String content;

//    @ManyToMany
//    @JoinTable(
//            name = "report_task",
//            joinColumns = @JoinColumn(name = "report_id"),
//            inverseJoinColumns = @JoinColumn(name = "task_id")
//    )
//    private List<TaskEntity> tasks = new ArrayList<>();

    private Long countUsers;

    private Long timeToCountUser;

    private Long timeToCountTask;

    private Long timeToCreatedReport;
}
