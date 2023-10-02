package com.example.order.mediator;

import com.example.order.entity.Order;
import com.example.order.entity.OrderDTO;
import com.example.order.service.OrderService;
import com.example.order.translators.OrderDTOToOrder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.coffeecode.entity.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMediator
{
    private final OrderDTOToOrder orderDTOToOrder;
    private final OrderService orderService;

    public ResponseEntity<?> createOrder(OrderDTO orderDTO, HttpServletRequest request, HttpServletResponse response)
    {
        Order order = orderDTOToOrder.toOrder(orderDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE,"application/json");
        return ResponseEntity.status(302).headers(headers).body(orderService.createOrder(order,request,response));
    }
}
