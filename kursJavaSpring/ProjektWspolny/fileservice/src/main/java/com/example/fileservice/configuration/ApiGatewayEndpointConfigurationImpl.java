package com.example.fileservice.configuration;


import jakarta.annotation.PostConstruct;
import org.coffeecode.ApiGatewayEndpointConfiguration;
import org.coffeecode.entity.Endpoint;
import org.coffeecode.entity.HttpMethod;
import org.coffeecode.entity.Response;
import org.coffeecode.entity.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiGatewayEndpointConfigurationImpl implements ApiGatewayEndpointConfiguration
{
    @Value("${api-gateway.url}")
    private String GATEWAY_URL;

    @PostConstruct
    public void startrOperation()
    {
        initMap();
        register();
    }

    @Override
    public void initMap()
    {
        endpointList.add(new Endpoint("api/v1/image", HttpMethod.GET, Role.GUEST));
        endpointList.add(new Endpoint("api/v1/image", HttpMethod.POST, Role.USER));
        endpointList.add(new Endpoint("api/v1/image", HttpMethod.DELETE, Role.ADMIN));
        endpointList.add(new Endpoint("api/v1/image", HttpMethod.PATCH, Role.USER));
    }

    @Override
    public void register()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Response> response = restTemplate.postForEntity(GATEWAY_URL, endpointList, Response.class);
        if(response.getStatusCode().isError()) throw new RuntimeException();
    }


}
