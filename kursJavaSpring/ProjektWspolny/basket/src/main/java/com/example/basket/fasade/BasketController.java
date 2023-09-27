package com.example.basket.fasade;

import com.example.basket.entity.BasketItemAddDTO;
import com.example.basket.entity.Response;
import com.example.basket.exceptions.BasketItemDontExistException;
import com.example.basket.exceptions.NoBasketInfoException;
import com.example.basket.service.BasketService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/basket")
@RequiredArgsConstructor
public class BasketController
{
    private final BasketService basketService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(@RequestBody BasketItemAddDTO basketItemAddDTO, HttpServletRequest request, HttpServletResponse response)
    {
        return basketService.add(basketItemAddDTO, request, response);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestParam String uuid, HttpServletRequest request)
    {
        return basketService.delete(uuid, request);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getItem(HttpServletRequest request)
    {
        return basketService.getItems(request);
    }



    @ExceptionHandler(BasketItemDontExistException.class)
    private ResponseEntity<Response> handlerException(BasketItemDontExistException exception)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(exception.getMessage()));
    }

    @ExceptionHandler(NoBasketInfoException.class)
    private ResponseEntity<Response> handlerException(NoBasketInfoException exception)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response(exception.getMessage()));
    }
}
