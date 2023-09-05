package com.example.fileservice.service;

import com.example.fileservice.entity.ImageEntity;
import com.example.fileservice.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class ImageService
{
    private final ImageRepository imageRepository;
    private final FTPService ftpService;

    public ImageEntity save(ImageEntity imageEntity)
    {
        return imageRepository.saveAndFlush(imageEntity);
    }

    public ImageEntity findByUid(String uid)
    {
        return imageRepository.findByUid(uid).orElse(null);
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public  void cleanImages()
    {
        imageRepository.findDontUseImages().forEach(value ->{
            try
            {
                ftpService.deleteFile(value.getPath());
                imageRepository.delete(value);
            }
            catch (IOException e)
            {
                System.out.println("Cant delete "+value.getUid());
            }
        });
    }
}
