package com.ms_example.simple_microservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("myService")
public class SimpleController {
    @GetMapping("/hello")
    public ResponseEntity<String> getMethodName() {
        String data = "{\"data\": \"hola mundo\"}";
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(data);
    }
    
}
