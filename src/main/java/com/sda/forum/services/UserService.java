package com.sda.forum.services;


import com.sda.forum.entities.User;
import com.sda.forum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
