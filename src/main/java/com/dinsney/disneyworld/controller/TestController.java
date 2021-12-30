package com.dinsney.disneyworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("inicio")
public class TestController {

    @GetMapping
    public String bienvenidos(){
        return "Bienvenidos";
    }

    @GetMapping("/mensaje")
    public String mensaje(){
        return "Este es un Mensaje";
    }

}
