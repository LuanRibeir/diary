package com.luanr.diary.service;

import java.util.List;
import java.util.Optional;

import com.luanr.diary.model.User;

public interface UserService {
    User save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);

    Optional<User> deleteById(Long id);

    Optional<User> updateById(Long id, User user) throws Exception;

    List<User> findByName(String name);
}
