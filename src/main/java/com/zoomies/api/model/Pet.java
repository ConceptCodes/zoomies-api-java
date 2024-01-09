package com.zoomies.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.internal.connection.Time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pets")
public class Pet {
    @Id
    private String id;

    private String name;

    private Integer age;

    private String breed;

    private Time createdAt;

    private Time updatedAt;

}
