package com.example.auth.exceptions;

public class UserExistingWithEmail extends RuntimeException
{

    public UserExistingWithEmail(String message)
    {
        super(message);
    }

    public UserExistingWithEmail(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UserExistingWithEmail(Throwable cause)
    {
        super(cause);
    }

}
