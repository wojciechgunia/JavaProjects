package com.example.order.service;

import com.example.order.entity.notify.Notify;
import com.example.order.exceptions.BadSignatureException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SignatureValidator
{

    @Value("${payu.client-key}")
    private String second_key;

    public void validate(String header, Notify notify) throws NoSuchAlgorithmException, JsonProcessingException, BadSignatureException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String body = objectMapper.writeValueAsString(notify);
        Map<String, String> signature = parseHeader(header);
        String concatenated = body+second_key;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = concatenated.getBytes();
        byte[] digest = md.digest(bytes);
        StringBuilder hexString = new StringBuilder();
        for(byte b : digest)
        {
            hexString.append(String.format("%02x", b));
        }
//        if(!hexString.toString().equals(signature.get("signature")))
//        {
//            throw new BadSignatureException();
//        }
    }

    private Map<String, String> parseHeader(String header)
    {
        header = header.replace(" ", "");
        String[] keyValuePairs = header.split(";");
        Map<String, String> headerMap = new HashMap<>();
        for (String keyValue : keyValuePairs)
        {
            String[] parts = keyValue.split("=");
            if(parts.length==2)
            {
                String key = parts[0];
                String value = parts[1];
                headerMap.put(key, value);
            }
        }
        return headerMap;
    }
}
