package com.example.gateway.fasada;

import com.example.gateway.filter.RouteValidator;
import lombok.RequiredArgsConstructor;
import org.coffeecode.entity.Response;
import org.coffeecode.entity.Endpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/gateway")
@RequiredArgsConstructor
public class RegistrationController
{
    private final RouteValidator routeValidator;

    @PostMapping
    public ResponseEntity<Response> register(@RequestBody List<Endpoint> endpoints)
    {
//        List<Endpoint> endpoints = new ArrayList<>();
        routeValidator.addEndpoints(endpoints);
        return ResponseEntity.ok(new Response("Successfully register new endpoints"));
    }

}
