package com.example.auth.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRegisterDTO
{
    private String login;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    private Role role;
}
