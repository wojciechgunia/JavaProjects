package com.example.fileservice.service;

import com.example.fileservice.entity.ImageEntity;
import com.example.fileservice.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService
{
    private final ImageRepository imageRepository;

    public ImageEntity save(ImageEntity imageEntity)
    {
        return imageRepository.saveAndFlush(imageEntity);
    }

    public ImageEntity findByUid(String uid)
    {
        return imageRepository.findByUid(uid).orElse(null);
    }
}
