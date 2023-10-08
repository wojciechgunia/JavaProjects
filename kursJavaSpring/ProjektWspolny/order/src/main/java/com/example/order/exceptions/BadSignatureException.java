package com.example.order.exceptions;

public class BadSignatureException extends RuntimeException
{
    public BadSignatureException()
    {
    }

    public BadSignatureException(String message)
    {
        super(message);
    }

    public BadSignatureException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public BadSignatureException(Throwable cause)
    {
        super(cause);
    }
}
