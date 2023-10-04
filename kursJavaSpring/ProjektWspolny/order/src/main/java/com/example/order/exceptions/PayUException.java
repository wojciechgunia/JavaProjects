package com.example.order.exceptions;

public class PayUException extends RuntimeException
{
    public PayUException()
    {
    }

    public PayUException(String message)
    {
        super(message);
    }

    public PayUException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PayUException(Throwable cause)
    {
        super(cause);
    }
}
