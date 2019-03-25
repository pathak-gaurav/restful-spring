package com.gauravpathak.controller;

import com.gauravpathak.model.Todo;
import com.gauravpathak.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    private TodoRepository repository;

    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> findAllTodo(@PathVariable("username") String username) {
        return repository.findAll();
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity deleteById(@PathVariable("username") String username, @PathVariable("id") Long id) {
        if (repository.findById(id).orElse(null) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        repository.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity findById(@PathVariable("username") String username, @PathVariable("id") Long id) {
        if (repository.findById(id).orElse(null) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            Optional<Todo> todo = repository.findById(id);
            return new ResponseEntity(todo, HttpStatus.OK);
        }
    }

    @PutMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity update(@PathVariable("username") String username, @PathVariable("id") Long id, @RequestBody Todo todo) {
        if (repository.findById(id).orElse(null) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            Todo updated = repository.save(todo);
            return new ResponseEntity(updated, HttpStatus.OK);
        }
    }

    @PostMapping(path = "/users/{username}/todos/")
    public ResponseEntity save(@PathVariable("username") String username, @RequestBody Todo todo) {
        Todo save = repository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
