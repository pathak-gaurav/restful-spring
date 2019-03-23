package com.gauravpathak.controller;

import com.gauravpathak.model.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping("/hello-world/{message}")
    public HelloWorldBean helloWorldBean(@PathVariable("message") String message) {
        return new HelloWorldBean("Hello " + message);
    }
}