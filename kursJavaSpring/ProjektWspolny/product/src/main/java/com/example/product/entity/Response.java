package com.example.product.entity;

import lombok.Getter;

import java.sql.Timestamp;


@Getter
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
