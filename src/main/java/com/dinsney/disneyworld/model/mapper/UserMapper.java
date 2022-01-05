package com.dinsney.disneyworld.model.mapper;

import com.dinsney.disneyworld.model.entity.UserEntity;
import com.dinsney.disneyworld.model.request.RegisterRequest;
import com.dinsney.disneyworld.model.response.RegisterResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toEntity(RegisterRequest registerRequest){
        return UserEntity.builder()
                .username(registerRequest.getUsername())
                .password(registerRequest.getPassword())
                .build();
    }

    public RegisterResponse toDTO(UserEntity userEntity){
        return RegisterResponse.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .jwt("JWT")
                .build();
    }

}
