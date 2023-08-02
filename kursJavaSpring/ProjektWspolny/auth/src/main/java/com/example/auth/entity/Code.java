package com.example.auth.entity;

public enum Code
{
    SUCCESS("Operacja zakończona sukcesem"),
    PERMIT("Przyznano dostep"),
    A1("Nie udało się zalogować"),
    A2("Podane dane są nieprawidłowe"),
    A3("Wskazany token jest pusty lub nie ważny"),
    A4("Użytkownik o wskazanej nazwie już istnieje"),
    A5("Użytkownik o wskazanym adresie e-mail już istnieje");



    public final String label;
    private Code(String label)
    {
        this.label = label;
    }

}
