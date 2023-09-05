package com.example.fileservice.fasade;

import com.example.fileservice.entity.ImageResponse;
import com.example.fileservice.mediator.MediatorImage;
import com.example.fileservice.service.FTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1/image")
@RequiredArgsConstructor
public class ImageController
{

    private final MediatorImage mediatorImage;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> saveFile(@RequestBody MultipartFile multipartFile)
    {
        return mediatorImage.saveImage(multipartFile);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<ImageResponse> deleteFile(@RequestParam String uid)
    {
        return mediatorImage.deleteImage(uid);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getFile(@RequestParam String uid)
    {
        return mediatorImage.getImage(uid);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity<ImageResponse> activeImage(@RequestParam String uid)
    {
        return mediatorImage.activeImage(uid);
    }
}
