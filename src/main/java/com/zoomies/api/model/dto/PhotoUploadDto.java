package com.zoomies.api.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoUploadDto {
    private String fileName;
    private String fileType;
    private MultipartFile file;
    private String userId;
    private String targetId;
}
