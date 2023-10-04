package com.example.order.service;

import com.example.order.entity.UserRegisterDTO;
import com.example.order.exceptions.UserDontLoginException;
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

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService
{
    @Value("${auth.service}")
    private String auth_url;

    private final RestTemplate restTemplate;

    public UserRegisterDTO getUserDetails(List<Cookie> cookie) throws HttpClientErrorException
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        StringBuilder cookieString = new StringBuilder();
        cookie.forEach(value -> {
            cookieString.append(value.getName()).append("=").append(value.getValue()).append(";");
        });
        if (cookieString.length() <= 0) throw new UserDontLoginException("User is not login");
        cookieString.deleteCharAt(cookieString.length()-1);
        httpHeaders.add("Cookie",cookieString.toString());
        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<UserRegisterDTO> response = restTemplate.exchange(auth_url, HttpMethod.GET, requestEntity, UserRegisterDTO.class);
        return response.getStatusCode().isError() ? null : response.getBody();
    }
}
