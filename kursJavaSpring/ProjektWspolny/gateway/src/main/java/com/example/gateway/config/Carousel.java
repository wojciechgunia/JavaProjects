package com.example.gateway.config;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class Carousel
{

    private final EurekaClient eurekaClient;
    List<InstanceInfo> instances = new ArrayList<>();
    int currentIndex = 0;

    public Carousel(EurekaClient eurekaClient)
    {
        this.eurekaClient = eurekaClient;
        try
        {
            initAuthCarousel();
        }
        catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        events();
    }

    public String getUriAuth()
    {
        StringBuilder stringBuilder = new StringBuilder();
        InstanceInfo instance = instances.get(currentIndex);
        stringBuilder.append(instance.getIPAddr()).append(":").append(instance.getPort());
        if (instances.size()-1 == currentIndex)
        {
            currentIndex = 0;
        }
        else
        {
            currentIndex++;
        }
        return stringBuilder.toString();
    }

    private void events()
    {
        eurekaClient.registerEventListener(eurekaEvent ->
        {
            initAuthCarousel();
        });
        eurekaClient.unregisterEventListener(eurekaEvent ->
        {
            try
            {
                initAuthCarousel();
            }
            catch (NullPointerException e)
            {
                e.printStackTrace();
            }
        });
    }

    private void initAuthCarousel() throws NullPointerException
    {
        instances = eurekaClient.getApplication("AUTH-SERVICE").getInstances();
    }
}