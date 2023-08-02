package com.example.auth.services;

import jakarta.servlet.http.Cookie;
import org.springframework.stereotype.Service;

@Service
public class CookieService
{
    public Cookie generateCookie(String name,String value,int exp)
    {
        Cookie cookie = new Cookie(name,value);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(exp/1000);
        return cookie;
    }
}
