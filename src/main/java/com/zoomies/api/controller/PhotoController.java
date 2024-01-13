package com.zoomies.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zoomies.api.model.User;
import com.zoomies.api.model.dto.GetByIdDto;
import com.zoomies.api.model.dto.PhotoResponseDto;
import com.zoomies.api.model.dto.PhotoUploadDto;
import com.zoomies.api.service.impl.PhotoService;
import com.zoomies.api.util.ResponseUtil;

@RequestMapping("/photo")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/upload")
    public ResponseEntity<User> upload(@Validated @RequestBody PhotoUploadDto photoUploadDto) {
        PhotoResponseDto response = photoService.upload(photoUploadDto);
        return ResponseUtil.success(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getById(@Validated @PathVariable GetByIdDto getByIdDto) {
        PhotoResponseDto response = photoService.getById(getByIdDto);
        return ResponseUtil.success(response);
    }
}
