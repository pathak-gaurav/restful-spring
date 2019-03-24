package com.gauravpathak.bootstrap;

import com.gauravpathak.model.Todo;
import com.gauravpathak.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private TodoRepository repository;

    public DataLoader(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        Todo one = new Todo("United States have the lowest GDP", false, LocalDate.now());
        Todo two = new Todo("Brexit date is near.", false, LocalDate.now());
        Todo three = new Todo("Mozart was a child prodigy!!", true, LocalDate.now());
        List<Todo> todoList = Arrays.asList(one, two, three);
        repository.saveAll(todoList);
    }
}
