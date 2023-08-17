package com.example.auth.services;

import com.example.auth.configuration.EmailConfiguration;
import com.example.auth.entity.User;
import com.google.common.base.Charsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Value;
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
    Resource activeTemplate;

    @Value("classpath:static/resetuj-haslo.html")
    Resource recoveryTemplate;

    public void sendActivation(User user)
    {
        log.info("--START Send Activation");
        try
        {
            String html = Files.toString(activeTemplate.getFile(), Charsets.UTF_8);
            html = html.replace("https://google.com",fontendUrl+"/aktywuj/"+user.getUuid());
            emailConfiguration.sendMail(user.getEmail(), html,"Aktywacja konta",true);
        }
        catch (IOException e)
        {
            log.info("Cant send mail");
            throw new RuntimeException(e);
        }
        log.info("--STOP Send Activation");
    }

    public void sendPasswordRecovery(User user, String uid)
    {
        log.info("--START Send Password Recovery");
        try
        {
            String html = Files.toString(recoveryTemplate.getFile(), Charsets.UTF_8);
            html = html.replace("https://google.com",fontendUrl+"/odzyskaj-haslo/"+uid);
            emailConfiguration.sendMail(user.getEmail(), html,"Odzyskanie hasła",true);
        }
        catch (IOException e)
        {
            log.info("Cant send mail");
            throw new RuntimeException(e);
        }
        log.info("--STOP Send Password Recovery");
    }
}
