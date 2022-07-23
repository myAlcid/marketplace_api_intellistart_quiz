package com.test.marketplace_api_intellistart_quiz.controller;

import com.test.marketplace_api_intellistart_quiz.entity.User;
import com.test.marketplace_api_intellistart_quiz.exception.DataNotFoundException;
import com.test.marketplace_api_intellistart_quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() throws DataNotFoundException {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @PostMapping("")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        String successfullyAddingUserMessage = "You successfully added user";
        return new ResponseEntity<>(successfullyAddingUserMessage, HttpStatus.CREATED);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") Long userId) throws DataNotFoundException {
        userService.deleteUser(userId);
        String successfullyDeletingUserMessage = "You successfully deleted user";
        return ResponseEntity.ok().body(successfullyDeletingUserMessage);
    }
}
