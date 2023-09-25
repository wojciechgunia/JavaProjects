package com.example.basket.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Response
{
    private final String timestamp;
    private final String message;
    public Response(String message)
    {
        this.timestamp = String.valueOf(new Timestamp(System.currentTimeMillis()));
        this.message = message;
    }
}
