package com.example.basket.service;

import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Service;

@Service
public class CookieService
{
    public Cookie generateCookie(String name, String value)
    {
        Cookie cookie = new Cookie(name,value);
        cookie.setHttpOnly(false);
        cookie.setPath("/");
        cookie.setMaxAge(36000000);
        cookie.setHttpOnly(true);
        return cookie;
    }
}
