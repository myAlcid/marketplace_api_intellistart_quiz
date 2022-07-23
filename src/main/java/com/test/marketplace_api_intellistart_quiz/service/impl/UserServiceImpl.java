package com.test.marketplace_api_intellistart_quiz.service.impl;

import com.test.marketplace_api_intellistart_quiz.entity.User;
import com.test.marketplace_api_intellistart_quiz.exception.DataNotFoundException;
import com.test.marketplace_api_intellistart_quiz.repository.UserRepository;
import com.test.marketplace_api_intellistart_quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() throws DataNotFoundException {
        List<User> allUsers = userRepository.findAll();
        if (allUsers.size() == 0) {
            throw new DataNotFoundException("Users not found");
        }
        return allUsers;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) throws DataNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User not found"));
        userRepository.delete(user);
    }
}
