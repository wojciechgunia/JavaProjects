package com.example.order.service;

import com.example.order.entity.ListBasketItemDTO;
import com.example.order.exceptions.BasketDontExistException;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class BasketService
{
    private final RestTemplate restTemplate;

    @Value("${basket.service}")
    private String BASKET_URL;

    public ListBasketItemDTO getBasket(Cookie value)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", value.getName()+"="+value.getValue());
        ResponseEntity<ListBasketItemDTO> response;
        try
        {
            response = restTemplate.exchange(BASKET_URL, HttpMethod.GET, new HttpEntity<String>(headers), ListBasketItemDTO.class);
        }
        catch (HttpClientErrorException e)
        {
            throw new BasketDontExistException("Basket don't exist");
        }

        if(response.getStatusCode().isError()) throw new BasketDontExistException("Basket don't exist");
        return response.getBody();
    }

    public void removeBasket(Cookie value, String uuid)
    {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", value.getName()+"="+value.getValue());
        restTemplate.exchange(BASKET_URL+"?uuid="+uuid, HttpMethod.DELETE, new HttpEntity<String>(headers), String.class);
    }


}
