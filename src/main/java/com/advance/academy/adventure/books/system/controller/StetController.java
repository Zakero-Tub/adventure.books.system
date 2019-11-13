package com.advance.academy.adventure.books.system.controller;

import com.advance.academy.adventure.books.system.model.adventure.Step;
import com.advance.academy.adventure.books.system.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/step")
public class StetController {

    private final StepService stepService;

    @Autowired
    public StetController(StepService stepService) {
        this.stepService = stepService;
    }

    @PostMapping
    public Step createOrUpdate (@RequestBody Step step){
        return stepService.createOrUpdate(step);
    }
}
