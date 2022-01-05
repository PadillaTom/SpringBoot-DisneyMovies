package com.dinsney.disneyworld.auth.service;

import com.dinsney.disneyworld.model.entity.UserEntity;
import com.dinsney.disneyworld.model.mapper.UserMapper;
import com.dinsney.disneyworld.model.request.RegisterRequest;
import com.dinsney.disneyworld.model.response.RegisterResponse;
import com.dinsney.disneyworld.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsCustomService implements UserDetailsService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    public RegisterResponse createNewUser(RegisterRequest registerRequest){
        var matchingUser = userRepository.findByUsername(registerRequest.getUsername());
        if(matchingUser.isPresent()) throw new IllegalArgumentException("El usuario ya existe.");
        registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        UserEntity newUser = userMapper.toEntity(registerRequest);
        newUser = userRepository.save(newUser);
        return userMapper.toDTO(newUser);
    }

}
