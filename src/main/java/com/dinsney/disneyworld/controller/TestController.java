package com.dinsney.disneyworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hola")
public class TestController {

    @GetMapping
    public String mensaje(){
        return "Bienvenidos";
    }
}
