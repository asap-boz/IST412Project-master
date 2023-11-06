package com.example.ist412project.service;

import com.example.ist412project.model.UserInfoModel;
import com.example.ist412project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserInfoModel getUserById(long userId) {
        Optional<UserInfoModel> userOptional = userRepository.findById(userId);

        UserInfoModel user = null;
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + userId);
        }
        return user;
    }

    @Override
    public void deleteUserById(long userID) {

    }

    @Override
    public Page<UserInfoModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.userRepository.findAll(pageable);
    }

    @Override
    public List<UserInfoModel> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(UserInfoModel user) {

    }

    @Override
    public boolean validateUser(String username, String password) {
        UserInfoModel user = userRepository.findByUserNameAndPassword(username, password);
        return user != null; // User is considered validated if found
    }

    @Override
    public void createUser(UserInfoModel user) {

    }
}
