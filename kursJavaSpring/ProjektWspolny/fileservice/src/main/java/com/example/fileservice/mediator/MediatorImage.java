package com.example.fileservice.mediator;

import com.example.fileservice.entity.ImageEntity;
import com.example.fileservice.service.FTPService;
import com.example.fileservice.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class MediatorImage
{
    private final FTPService ftpService;
    private final ImageService imageService;

    public ResponseEntity<?> saveImage(MultipartFile multipartFile)
    {
        try
        {
            ImageEntity imageEntity = ftpService.uploadFileToFTP(multipartFile);
            imageService.save(imageEntity);
            return ResponseEntity.ok("");
        }
        catch (RuntimeException e)
        {
            return ResponseEntity.status(400).body("Nie udało się wgrać pliku");
        }

    }

}
