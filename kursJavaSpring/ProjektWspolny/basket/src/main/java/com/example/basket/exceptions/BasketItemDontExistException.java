package com.example.basket.exceptions;

public class BasketItemDontExistException extends RuntimeException
{
    public BasketItemDontExistException(String message)
    {
        super(message);
    }

    public BasketItemDontExistException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BasketItemDontExistException(Throwable cause)
    {
        super(cause);
    }
}
