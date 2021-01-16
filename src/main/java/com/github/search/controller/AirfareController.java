package com.github.search.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class AirfareController {

    @GetMapping
    public String working()
    {
        return "it worked";
    }
}
