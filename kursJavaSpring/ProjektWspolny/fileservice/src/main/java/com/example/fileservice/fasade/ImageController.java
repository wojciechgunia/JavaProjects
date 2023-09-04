package com.example.fileservice.fasade;

import com.example.fileservice.mediator.MediatorImage;
import com.example.fileservice.service.FTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
