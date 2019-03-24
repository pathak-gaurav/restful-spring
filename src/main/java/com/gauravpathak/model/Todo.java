package com.gauravpathak.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo {

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private boolean done;
    private LocalDate targetDate;

    public Todo(String description, boolean done, LocalDate targetDate) {
        this.description = description;
        this.done = done;
        this.targetDate = targetDate;
    }
}
