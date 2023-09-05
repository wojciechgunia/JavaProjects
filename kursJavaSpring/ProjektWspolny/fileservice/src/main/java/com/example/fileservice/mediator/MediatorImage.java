package com.example.fileservice.mediator;

import com.example.fileservice.entity.ImageDTO;
import com.example.fileservice.entity.ImageEntity;
import com.example.fileservice.entity.ImageResponse;
import com.example.fileservice.exceptions.FtpConnectionException;
import com.example.fileservice.service.FTPService;
import com.example.fileservice.service.ImageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@AllArgsConstructor
public class MediatorImage
{
    private final FTPService ftpService;
    private final ImageService imageService;

    public ResponseEntity<?> saveImage(MultipartFile multipartFile)
    {
        try
        {
            if(multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")+1).equals("png"))
            {
                ImageEntity imageEntity = ftpService.uploadFileToFTP(multipartFile);
                imageService.save(imageEntity);
                return ResponseEntity.ok(ImageDTO.builder().uid(imageEntity.getUid()).createAt(imageEntity.getCreateAt()).build());
            }
            return ResponseEntity.status(400).body(new ImageResponse("Wrong file type"));
        }
        catch (IOException e)
        {
            return ResponseEntity.status(400).body(new ImageResponse("File don't exist"));
        }
        catch (FtpConnectionException e1)
        {
            return ResponseEntity.status(400).body(new ImageResponse("File couldn't be saved"));
        }
    }

    public ResponseEntity<ImageResponse> deleteImage(String uid)
    {
        try
        {
            ImageEntity imageEntity = imageService.findByUid(uid);
            if (imageEntity != null)
            {
                ftpService.deleteFile(imageEntity.getPath());
                return ResponseEntity.ok(new ImageResponse("File deleted success"));
            }
            else
            {
                throw new IOException("File don't exist");
            }

        }
        catch (IOException e)
        {
            return ResponseEntity.status(400).body(new ImageResponse("File don't exist"));
        }
        catch (FtpConnectionException e1)
        {
            return ResponseEntity.status(400).body(new ImageResponse("File couldn't be deleted"));
        }

    }

    public ResponseEntity<?> getImage(String uid)
    {
        try
        {
            ImageEntity imageEntity = imageService.findByUid(uid);
            if (imageEntity != null)
            {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_PNG);
                return new ResponseEntity<>(ftpService.getFile(imageEntity).toByteArray(),headers, HttpStatus.OK);
            }
            else
            {
                throw new IOException("File don't exist");
            }

        }
        catch (IOException e)
        {
            return ResponseEntity.status(400).body(new ImageResponse("File don't exist"));
        }
        catch (FtpConnectionException e1)
        {
            return ResponseEntity.status(400).body(new ImageResponse("File couldn't be downloaded"));
        }
    }

    public ResponseEntity<ImageResponse> activeImage(String uid)
    {
        ImageEntity imageEntity = imageService.findByUid(uid);
        if (imageEntity != null)
        {
            imageEntity.setUsed(true);
            imageService.save(imageEntity);
            return ResponseEntity.ok(new ImageResponse("Image successfuly activated"));
        }
        else
        {
            return ResponseEntity.status(400).body(new ImageResponse("File don't exist"));
        }
    }
}
