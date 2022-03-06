package com.practice.javawebservice.Repository;

import com.practice.javawebservice.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
// @Repository interacts with the database
// @Transactional Ie the whole job in one go or will be rolled back
// transaction also required when we do changes to database
// DAO- data access object class helps us to access objects from the database
public class UserDAOService {

    //when an object is saved with persistence method it is traced by the
    // persistence context
    @PersistenceContext
    private EntityManager entityManager;

    public Long insertUser(User user){
        entityManager.persist(user);
        return user.getUserId();
    }
}
