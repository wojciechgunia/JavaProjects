package com.example.demo;

public class Call
{
    private String name;

    public void setName(String name)
    {
        this.name = name;
    }

    public void start(){
        System.out.println("Nawiązano połączenie: "+name);
    }
}
