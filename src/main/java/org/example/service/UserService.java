package org.example.service;

import org.example.dao.UserRepository;
import org.example.model.User;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean create(User user) {
        return userRepository.create(user);
    }

    public User findById(int id){
        return this.userRepository.findById(id);
    }

    public boolean update(User user) {
        if (user != null) {
            return this.userRepository.update(user);
        }
        else {
            return false;
        }
    }

    public boolean delete(User user){
        if (user != null) {
            return this.userRepository.delete(user);
        }
        else {
            return false;
        }
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }

}
