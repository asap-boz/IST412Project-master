package com.example.ist412project.service;

import com.example.ist412project.model.UserInfo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    List<UserInfo> getAllUsers();
    void saveUser(UserInfo user);
    UserInfo getUserById(long userID);
    void deleteUserById(long userID);
    Page<UserInfo> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

    boolean validateUser(String userName, String password);

    void createUser(UserInfo user);
}
