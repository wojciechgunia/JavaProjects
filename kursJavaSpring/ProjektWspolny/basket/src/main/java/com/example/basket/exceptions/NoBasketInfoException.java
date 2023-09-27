package com.example.basket.exceptions;

public class NoBasketInfoException extends RuntimeException
{
    public NoBasketInfoException()
    {
    }

    public NoBasketInfoException(String message)
    {
        super(message);
    }

    public NoBasketInfoException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public NoBasketInfoException(Throwable cause)
    {
        super(cause);
    }
}
