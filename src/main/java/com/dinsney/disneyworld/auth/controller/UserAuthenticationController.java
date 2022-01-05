package com.dinsney.disneyworld.auth.controller;

import com.dinsney.disneyworld.auth.service.UserDetailsCustomService;
import com.dinsney.disneyworld.model.request.RegisterRequest;
import com.dinsney.disneyworld.model.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserAuthenticationController {

    private final UserDetailsCustomService userDetailsCustomService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse createUser(@RequestBody RegisterRequest registerRequest){
        return userDetailsCustomService.createNewUser(registerRequest);
    }

}
