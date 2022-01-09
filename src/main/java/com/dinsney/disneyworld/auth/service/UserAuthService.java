package com.dinsney.disneyworld.auth.service;

import com.dinsney.disneyworld.model.mapper.AuthenticationMapper;
import com.dinsney.disneyworld.model.request.AuthenticationRequest;
import com.dinsney.disneyworld.model.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserAuthService {

    private final UserDetailsCustomService userDetailsCustomService;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationMapper authenticationMapper;
    private final JwtUtil jwtUtil;

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest){
        UserDetails userDetails = userDetailsCustomService.loadUserByUsername(authenticationRequest.getUsername());
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(),
                authenticationRequest.getPassword(),
                Collections.emptyList()
        );
        authenticationManager.authenticate(authenticationToken);

        // TODO: Si es correcto: Armamos una Nueva JWT. (Armada con los datos de mi usuario en la memoria de Spring)
        String jwt = jwtUtil.generateToken(userDetails);
        return authenticationMapper.toDTO(userDetails, jwt);
    }

}
