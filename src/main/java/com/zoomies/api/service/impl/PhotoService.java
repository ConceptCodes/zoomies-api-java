package com.zoomies.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zoomies.api.constants.enums.PhotoStatus;
import com.zoomies.api.model.Photo;
import com.zoomies.api.model.dto.GetByIdDto;
import com.zoomies.api.model.dto.PhotoResponseDto;
import com.zoomies.api.model.dto.PhotoUploadDto;
import com.zoomies.api.repository.PhotoRepository;

public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    private final StorageService storageService;

    @Autowired
    public PhotoService(StorageService storageService) {
        this.storageService = storageService;
    }

    public PhotoResponseDto upload(PhotoUploadDto photoUploadDto) {
        Photo photo = new Photo();
        photo.setStatus(PhotoStatus.PENDING);
        photo.setUserId(photoUploadDto.getUserId());
        photo.setTargetId(photoUploadDto.getTargetId());
        photoRepository.save(photo);

        storageService.store(photoUploadDto.getFile());

        photo.setStatus(PhotoStatus.APPROVED);
        photoRepository.save(photo);

        PhotoResponseDto response = new PhotoResponseDto();
        response.setId(photo.getId());
        response.setStatus(photo.getStatus());
        response.setUserId(photo.getUserId());
        response.setTargetId(photo.getTargetId());

        return response;
    }

    public PhotoResponseDto getById(GetByIdDto getByIdDto) {
        Photo photo = photoRepository.findById(getByIdDto.getId()).get();
        PhotoResponseDto response = new PhotoResponseDto();
        response.setId(photo.getId());
        response.setUserId(photo.getUserId());
        response.setTargetId(photo.getTargetId());
        response.setStatus(photo.getStatus());

        return response;
    }

}
