package com.upao.api_book.service;

import com.upao.api_book.model.User;
import com.upao.api_book.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(String username, String password, String email) {
        User user = new User(username,password,email, LocalDateTime.now(), LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(
                "El usuario con id "+id+" no se ha encontrado"
        ));
    }

    @Override
    public User updateUser(Long id, String username, String password, String email) {
        User user = getUserById(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(getUserById(id));
    }

}
