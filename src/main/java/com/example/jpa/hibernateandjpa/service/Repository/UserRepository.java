package com.example.jpa.hibernateandjpa.service.Repository;

import com.example.jpa.hibernateandjpa.entities.Users;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    @Query(value = "FROM Users")
    List<Users> fetchAllTheUsers();


    @Modifying
    @Transactional
    @Query(value = "UPDATE Users SET password = :password WHERE userName = :username")
    int updateUserPassword(@Param("username") String username, @Param("password") String password);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Users SET userName = :newUserName WHERE userName = :currentUserName")
    int updateUserName(@Param("newUserName") String newUserName, @Param("currentUserName") String currentUserName);


    @Transactional
    @Modifying
    @Query(value = "DELETE Users WHERE userName = :userName")
    int deleteUser(@Param("userName") String userName );
}
