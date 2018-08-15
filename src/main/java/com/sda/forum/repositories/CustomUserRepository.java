package com.sda.forum.repositories;

import com.sda.forum.entities.User;
import org.springframework.stereotype.Repository;


public interface CustomUserRepository {

    User updateUserPostsNumber(User user, int postNumber);
}
