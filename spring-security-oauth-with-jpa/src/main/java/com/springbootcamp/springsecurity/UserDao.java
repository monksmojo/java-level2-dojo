package com.springbootcamp.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {

    @Autowired
    UserRepository userRepository;

    AppUser loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        System.out.println(user);

        List<GrantedAuthority> grantedAuthorities = new LinkedList<>();
        for (Role role : user.getRole()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getAuthority()));
        }

        if (username != null) {
            return new AppUser(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new RuntimeException();
        }

    }
}
