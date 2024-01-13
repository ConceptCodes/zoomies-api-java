package com.zoomies.api.service;

import com.zoomies.api.model.dto.GetByIdDto;
import com.zoomies.api.model.dto.PhotoResponseDto;
import com.zoomies.api.model.dto.PhotoUploadDto;

public interface IPhotoService {
    PhotoResponseDto upload(PhotoUploadDto photoUploadDto);

    PhotoResponseDto getById(GetByIdDto getByIdDto);
}