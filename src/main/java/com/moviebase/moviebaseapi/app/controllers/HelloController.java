package com.moviebase.moviebaseapi.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Zdravo Umi :)";
    }
}
