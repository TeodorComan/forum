package com.sda.forum.repositories;

import com.sda.forum.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository {

    User customUpdateUserPostNumber(User user, int postNumber);
}
