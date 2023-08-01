package com.example.auth.entity;

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
    private String password;
    private Role role;
}
