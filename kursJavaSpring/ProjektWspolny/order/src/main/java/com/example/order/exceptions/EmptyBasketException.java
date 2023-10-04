package com.example.order.exceptions;

public class EmptyBasketException extends RuntimeException
{
    public EmptyBasketException()
    {
    }

    public EmptyBasketException(String message)
    {
        super(message);
    }

    public EmptyBasketException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public EmptyBasketException(Throwable cause)
    {
        super(cause);
    }
}
