package com.moviebase.moviebaseapi.app.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class HelloController {

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Zdravo Umi :)";
    }
}
