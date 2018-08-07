package com.sda.forum.repositories;

import com.sda.forum.entities.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Repository
public class UserRepositoryCustomImpl implements CustomUserRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public User customUpdateUserPostNumber(User user, int postNumber) {
        Query query = entityManager.createNativeQuery("UPDATE user SET postNumber = ? WHERE user = ? ");
        query.setParameter(2, postNumber );
        query.setParameter(1, user );
        query.executeUpdate();
        user.setPostNumber(postNumber);

        return user;
    }
}
