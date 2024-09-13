package com.example.jpa.hibernateandjpa.controller;


import com.example.jpa.hibernateandjpa.entities.Users;
import com.example.jpa.hibernateandjpa.service.impl.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userinterface;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserController(UserService userinterface, ObjectMapper objectMapper) {
        this.userinterface = userinterface;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/save_user")
    public ResponseEntity<Object> saveUserData(@RequestBody(required = true) Users userData) throws JsonProcessingException {
        userinterface.saveUserRecord(userData);
        return ResponseEntity.status(HttpStatus.OK).body("user data saved successfully");
    }

    @GetMapping("/fetch_all_users")
    public ResponseEntity<Object> fetchAllUsers() throws JsonProcessingException {
        List<Users> allUserData = userinterface.fetchAllUsersData();
        String jsonUsers = objectMapper.writeValueAsString(allUserData);
        return ResponseEntity.status(HttpStatus.OK).body(jsonUsers);
    }

    @GetMapping("/fetch_user")
    public ResponseEntity<Object> fetchUser(@RequestParam(required = true)Integer id) throws JsonProcessingException {
        Users allUserData = userinterface.fetchUserData(id);
        String jsonUsers = objectMapper.writeValueAsString(allUserData);
        return ResponseEntity.status(HttpStatus.OK).body(jsonUsers);
    }

    @PostMapping("/update_password")
    public ResponseEntity<Object> updateUserData(@RequestBody(required = true)Users userCredentials){
        userinterface.updateUserData(userCredentials);
        return ResponseEntity.status(HttpStatus.OK).body("user data updated successfully");
    }


}
