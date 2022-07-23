package com.test.marketplace_api_intellistart_quiz.service;

import com.test.marketplace_api_intellistart_quiz.entity.User;
import com.test.marketplace_api_intellistart_quiz.exception.DataNotFoundException;

import java.util.List;

public interface UserService {

    List<User> getAll() throws DataNotFoundException;

    void addUser(User user);

    void deleteUser(Long id) throws DataNotFoundException;
}
