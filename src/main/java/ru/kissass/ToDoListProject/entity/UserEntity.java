package ru.kissass.ToDoListProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ru.kissass.ToDoListProject.utility.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "my_Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    private String password;

    private String firsName;

    private String lastName;

    /*@Column(nullable = false, unique = true)
    private String email;*/

    @ManyToMany
    @JoinTable(
            name = "user_project",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<ProjectEntity> project = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CommentEntity> comments = new ArrayList<>();

}