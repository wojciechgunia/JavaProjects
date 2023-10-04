package com.example.order.exceptions;

public class UknowDeliveryTypException extends RuntimeException
{
    public UknowDeliveryTypException()
    {
    }

    public UknowDeliveryTypException(String message)
    {
        super(message);
    }

    public UknowDeliveryTypException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public UknowDeliveryTypException(Throwable cause)
    {
        super(cause);
    }
}
