package com.upao.api_book.service;

import com.upao.api_book.model.User;

import java.util.List;

public interface UserService {
    User createUser(String username, String password, String email);
    List<User> getAllUser();
    User getUserById(Long id);
    //User getUserByUsername(String username);
    User updateUser(Long id, String username, String password, String email);
    void deleteUser(Long id);

}
