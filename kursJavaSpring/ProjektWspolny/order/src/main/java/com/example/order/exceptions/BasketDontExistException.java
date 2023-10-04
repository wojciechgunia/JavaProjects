package com.example.order.exceptions;

public class BasketDontExistException extends RuntimeException
{
    public BasketDontExistException()
    {
    }

    public BasketDontExistException(String message)
    {
        super(message);
    }

    public BasketDontExistException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BasketDontExistException(Throwable cause)
    {
        super(cause);
    }
}
