package com.example.order.exceptions;

public class UserDontLoginException extends RuntimeException
{
    public UserDontLoginException()
    {
    }

    public UserDontLoginException(String message)
    {
        super(message);
    }

    public UserDontLoginException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UserDontLoginException(Throwable cause)
    {
        super(cause);
    }
}
