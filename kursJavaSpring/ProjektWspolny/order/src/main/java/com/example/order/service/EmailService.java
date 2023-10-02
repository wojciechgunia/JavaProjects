package com.example.order.service;

import com.example.order.configuration.EmailConfiguration;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService
{
    private final EmailConfiguration emailConfiguration;
    @Value("${front.url}")
    private String fontendUrl;
    @Value("classpath:static/mail-aktywuj.html")
    Resource orderTemplate;

    public void sendOrder(String mail, String uuid)
    {
        log.info("--START Send Order");
        try
        {
            String html = Files.toString(orderTemplate.getFile(), Charsets.UTF_8);
            html = html.replace("https://google.com",fontendUrl+"/zamówienia/"+uuid);
            emailConfiguration.sendMail(mail, html,"Utworzono zamówienie",true);
        }
        catch (IOException e)
        {
            log.info("Cant send mail");
            throw new RuntimeException(e);
        }
        log.info("--STOP Send Order");
    }
}
