package com.practice.javawebservice.Configuration;

import com.practice.javawebservice.Repository.UserDAOService;
import com.practice.javawebservice.entity.User;
import com.practice.javawebservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCommandLineRunner implements CommandLineRunner {
    private static final Logger log=LoggerFactory.getLogger(UserCommandLineRunner.class);
    @Autowired
    private UserDAOService userDAOService;

    @Autowired
    private UserService userService;

    @Override

    public void run(String... args) throws Exception {
        // creating a user using userDaoService
        // userDaoService use EntityManager to save the user.
        User user=new User("Jack",34,"India");
        long insertedUserId=userDAOService.insertUser(user);
        log.info("user created -->"+user);
        log.info("with id->"+insertedUserId);

        // creating a user using repository to persist
        User user1=new User("jill",16,"Vietnam");
        insertedUserId=userService.createUser(user1);
        log.info("user created -->"+user1);
        log.info("with id->"+insertedUserId);

        // fetching the list of user using the repository function
        List<User> userList=userService.getAllUser();
        log.info("userList fetched-->"+userList);

        // fetching the single user
        User user2=userService.getSpecificUser(1l);
        log.info("specific userFetched-->"+userList);

    }
}
