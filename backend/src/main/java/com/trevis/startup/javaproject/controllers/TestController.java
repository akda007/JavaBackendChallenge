package com.trevis.startup.javaproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trevis.startup.javaproject.exception.AppResponseException;

@RestController
public class TestController {

    @GetMapping("test")
    public ResponseEntity<String> test(@RequestParam String letter) {

        if(letter.equals("a")) throw new AppResponseException("Essa não!", 400);

        return ResponseEntity.ok("Nice!");
    }   
}