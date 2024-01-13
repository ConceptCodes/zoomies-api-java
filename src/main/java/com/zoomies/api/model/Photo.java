package com.zoomies.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.internal.connection.Time;
import com.zoomies.api.constants.enums.PhotoStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "photos")
public class Photo {

    @Id
    private String id;
    private String userId;
    private String targetId;
    private String photoUrl;
    private PhotoStatus status;
    private Time createdAt;
    private Time updatedAt;

}
