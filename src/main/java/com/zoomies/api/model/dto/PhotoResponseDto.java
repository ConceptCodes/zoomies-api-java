package com.zoomies.api.model.dto;

import com.zoomies.api.constants.enums.PhotoStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhotoResponseDto {
    private String id;
    private String userId;
    private String targetId;
    private PhotoStatus status;
}
