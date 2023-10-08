package com.example.order.exceptions;

public class OrderDontExistException extends RuntimeException
{
    public OrderDontExistException()
    {
    }

    public OrderDontExistException(String message)
    {
        super(message);
    }

    public OrderDontExistException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public OrderDontExistException(Throwable cause)
    {
        super(cause);
    }
}
