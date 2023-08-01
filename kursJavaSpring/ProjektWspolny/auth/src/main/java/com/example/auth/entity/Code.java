package com.example.auth.entity;

public enum Code
{
    SUCCESS("Operation success"),
    A1("Nie udało się zalogować"),
    A2("Użytkownik o wskazanej nazwie nie istnieje");



    public final String label;
    private Code(String label)
    {
        this.label = label;
    }

}
