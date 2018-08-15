package com.sda.forum.repositories;

import com.sda.forum.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Repository
public class CustomUserRepositoryImpl implements CustomUserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public User updateUserPostsNumber(User user, int postNumber) {
        jdbcTemplate.update("UPDATE user SET postNumber = ? WHERE id = ? ", postNumber, user.getId());
        return user;
    }
}
