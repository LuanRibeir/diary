package com.luanr.diary.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.luanr.diary.model.User;
import com.luanr.diary.repository.UserRepository;
import com.luanr.diary.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> deleteById(Long id) {
        Optional<User> deletedUser = userRepository.findById(id);
        userRepository.deleteById(id);
        return deletedUser;
    }

    @Override
    public Optional<User> updateById(Long id, User user) throws Exception {

        if (!userRepository.existsById(id)) {
            throw new Exception("User does not exist.");
        }

        user.setId(id);
        userRepository.save(user);

        return userRepository.findById(id);
    }

}
