package com.example.auth.services;

import com.example.auth.configuration.EmailConfiguration;
import com.example.auth.entity.User;
import com.google.common.base.Charsets;
import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmailService
{
    private final EmailConfiguration emailConfiguration;
    @Value("${front.url}")
    private String fontendUrl;
    @Value("classpath:static/mail-aktywuj.html")
    Resource activeTemplate;

    public void sendActivation(User user)
    {
        try
        {
            String html = Files.toString(activeTemplate.getFile(), Charsets.UTF_8);
            html = html.replace("https://google.com",fontendUrl+"/aktywuj/"+user.getUuid());
            emailConfiguration.sendMail(user.getEmail(), html,"Aktywacja konta",true);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
