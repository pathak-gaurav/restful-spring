package com.gauravpathak.controller;

import com.gauravpathak.model.Todo;
import com.gauravpathak.repository.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    private TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> findAllTodo(@PathVariable("username") String username) {
        return repository.findAll();
    }
}
