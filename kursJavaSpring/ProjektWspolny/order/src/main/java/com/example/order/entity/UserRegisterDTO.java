package com.example.order.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegisterDTO
{
    private String login;
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;
    private String role;
}
