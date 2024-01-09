package com.zoomies.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zoomies.api.model.User;

public interface UserRepository extends CrudRepository<User, String> {

    Optional<User> findById(String id);

    User findByEmail(String email);

    Boolean existsByEmail(String email);

    List<User> findAll();

    @Override
    User save(User user);

    void deleteById(String id);

}
