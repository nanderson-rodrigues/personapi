package com.digitalinnovation.one.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
    
    @GetMapping
    public String getBook() {
        return "API Test!";
    }
    
}
