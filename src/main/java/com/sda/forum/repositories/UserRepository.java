package com.sda.forum.repositories;

import com.sda.forum.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {


    User findByUsername(String username);
}


