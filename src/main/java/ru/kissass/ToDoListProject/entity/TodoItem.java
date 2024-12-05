package ru.kissass.ToDoListProject.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "todo_items")
public class TodoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Description is required")
    private String description;

    private String color;//пока отвечает за категорию

    private Boolean isComplete;

    private String createdAt;

    private String updatedAt;

    @Override
    public String toString() {
        return String.format("TodoItem{id=%d, description='%s', isComplete='%s', createdAt='%s', updatedAt='%s'}",
                id, description, isComplete, createdAt, updatedAt);
    }

}