package com.example.order.fasade;

import com.example.order.entity.DeliverDTO;
import com.example.order.entity.OrderDTO;
import com.example.order.exceptions.BasketDontExistException;
import com.example.order.exceptions.EmptyBasketException;
import com.example.order.exceptions.PayUException;
import com.example.order.exceptions.UknowDeliveryTypException;
import com.example.order.mediator.OrderMediator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.coffeecode.entity.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/order")
@RequiredArgsConstructor
public class OrderController
{
    private final OrderMediator orderMediator;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO order, HttpServletResponse response, HttpServletRequest request)
    {
        return orderMediator.createOrder(order, request, response);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BasketDontExistException.class)
    public Response handleValidationExceptions(BasketDontExistException ex)
    {
        return new Response("Basket don't exist");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmptyBasketException.class)
    public Response handleValidationExceptions(EmptyBasketException ex)
    {
        return new Response("Basket is empty");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PayUException.class)
    public Response handleValidationExceptions(PayUException ex)
    {
        return new Response("PayU service error, please try later");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UknowDeliveryTypException.class)
    public Response handleValidationExceptions(UknowDeliveryTypException ex)
    {
        return new Response("Delivery type don't exist");
    }
}
