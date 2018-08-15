package com.sda.forum.services;


import com.sda.forum.entities.User;
import com.sda.forum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        if(user.getAge()>=18) {
            return userRepository.save(user);
        } else {
            throw new RuntimeException();
        }
    }

    public User readUser(int id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(User user) {
        if(true==false) {
            return userRepository.save(user);
        }

        throw new RuntimeException();
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Transactional
    public User updateUserPostsNumber(User user, int postNumber) {
        return userRepository.updateUserPostsNumber(user,postNumber);
    }
}
