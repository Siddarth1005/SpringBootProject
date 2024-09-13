package com.example.jpa.hibernateandjpa.service.impl;

import com.example.jpa.hibernateandjpa.entities.Users;
import com.example.jpa.hibernateandjpa.service.Repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;


@Primary
@Service
public class UserImpldao implements UserService {

//    Injecting entityManger
    EntityManager entityManager;
    UserRepository UserRepo;
    @Autowired
    public UserImpldao(EntityManager thisentityManager,UserRepository UserRepo ){
        this.entityManager = thisentityManager;
        this.UserRepo = UserRepo;
    }

    @Override
    @Transactional
    public void saveUserRecord(Users userData) {
        entityManager.persist(userData);
    }

    @Override
    public Users fetchUserData(Integer id) {
        Users userData = entityManager.find(Users.class,id);
        return userData;
    }

    @Override
    public List<Users> fetchAllUsersData() {
        List<Users> allusers = UserRepo.fetchAllTheUsers();
        return allusers;
    }


    @Override
    public void updateUserData(Users userData) {
        String username = userData.getUserName();
        String password = userData.getPassword();
        UserRepo.updateUserPassword(username, password);
    }

    @Override
    public void updateUserName(String newUsername, String currentUserName) {
        UserRepo.updateUserName(newUsername, currentUserName);
    }

    @Override
    @Transactional
    public void deleteUser(String userName) {
        UserRepo.deleteUser(userName);
    }


}
