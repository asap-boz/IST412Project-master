package com.example.ist412project.repository;

import com.example.ist412project.model.UserInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserInfoModel, Long> {
    // Retrieve a user by their username
    UserInfoModel findByUserName(String userName);
    // Retrieve a user by their user ID
    UserInfoModel getUserByUid(Long userID);
    // Retrieve a user by their username and password (used for authentication)
    UserInfoModel findByUserNameAndPassword(String username, String password);

}
