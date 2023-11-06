package com.example.ist412project.service;

import com.example.ist412project.model.UserInfoModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<UserInfoModel> getAllUsers();
    void saveUser(UserInfoModel user);
    UserInfoModel getUserById(long userID);
    void deleteUserById(long userID);
    Page<UserInfoModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    boolean validateUser(String userName, String password);

    void createUser(UserInfoModel user);
}
