package com.dinsney.disneyworld.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {

    private String username;

    private String jwt;

}
