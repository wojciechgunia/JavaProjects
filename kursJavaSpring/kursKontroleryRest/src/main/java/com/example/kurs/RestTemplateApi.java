package com.example.kurs;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestTemplateApi {

    RestTemplate restTemplate;

    public RestTemplateApi(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public String getQuotes() throws URISyntaxException{
        Map<String, String> params = new HashMap<>();
        params.put("category", "happiness");
        URI api_url = UriComponentsBuilder.fromUriString("https://api.api-ninjas.com/v1/quotes").queryParam("categorty", params.get("category")).build().toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Api-Key","feateafwatq353t6esww46tywe4t65");
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(api_url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }

}
