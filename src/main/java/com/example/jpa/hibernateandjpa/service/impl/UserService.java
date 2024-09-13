package com.example.jpa.hibernateandjpa.service.impl;

import com.example.jpa.hibernateandjpa.entities.Users;

import java.util.List;

public interface UserService {

//Create
    void saveUserRecord(Users userData);

//Read
    Users fetchUserData(Integer id);
    List<Users> fetchAllUsersData();

//Update
    void updateUserData(Users userData);
    void updateUserName(String username, String userName);

//Delete
    void deleteUser(String userName);

}
