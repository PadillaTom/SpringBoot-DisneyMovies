package com.dinsney.disneyworld.auth.controller;

import com.dinsney.disneyworld.auth.service.UserAuthService;
import com.dinsney.disneyworld.auth.service.UserDetailsCustomService;
import com.dinsney.disneyworld.model.request.AuthenticationRequest;
import com.dinsney.disneyworld.model.request.RegisterRequest;
import com.dinsney.disneyworld.model.response.AuthenticationResponse;
import com.dinsney.disneyworld.model.response.RegisterResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserAuthenticationController {

    private final UserDetailsCustomService userDetailsCustomService;
    private final UserAuthService userAuthService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse createUser(@RequestBody RegisterRequest registerRequest){
        return userDetailsCustomService.createNewUser(registerRequest);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse loginDeUsuario(@RequestBody AuthenticationRequest authenticationRequest){
        System.out.println(authenticationRequest);
        return userAuthService.login(authenticationRequest);
    }

}
