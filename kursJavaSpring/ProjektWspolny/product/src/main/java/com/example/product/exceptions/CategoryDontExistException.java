package com.example.product.exceptions;

public class CategoryDontExistException extends RuntimeException
{

    public CategoryDontExistException(String message)
    {
        super(message);
    }

    public CategoryDontExistException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CategoryDontExistException(Throwable cause)
    {
        super(cause);
    }

    public CategoryDontExistException()
    {
        super();
    }
}
