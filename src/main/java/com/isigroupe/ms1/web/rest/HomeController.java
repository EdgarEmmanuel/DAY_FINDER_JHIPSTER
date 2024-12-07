package com.isigroupe.ms1.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {


    @GetMapping("/home/ms1")
    public String getHome(){
        return "Hello World MS1!";
    }

}
