package com.example.basket.fasade;

import com.example.basket.entity.BasketItemAddDTO;
import com.example.basket.service.BasketService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
