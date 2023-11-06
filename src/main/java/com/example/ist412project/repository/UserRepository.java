package com.example.ist412project.repository;

import com.example.ist412project.model.UserInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserInfoModel, Long> {
    UserInfoModel findByUserName(String userName);
    UserInfoModel findByUserNameAndPassword(String username, String password);
    //Can add more queries

}
