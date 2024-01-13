package com.zoomies.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.zoomies.api.model.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {

    Optional<Photo> findById(String id);

    List<Photo> findAll();

    @Override
    Photo save(Photo photo);

    void deleteById(String id);

}