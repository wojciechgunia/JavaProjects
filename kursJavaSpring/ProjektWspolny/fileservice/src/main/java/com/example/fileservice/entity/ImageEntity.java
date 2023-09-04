package com.example.fileservice.entity;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class ImageEntity
{
    private long id;
    private String uid;
    private String path;
    private boolean isUsed;
    private LocalDate createAt;
}
