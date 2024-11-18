package com.cseazeem.carmanagement.Service;

import com.cseazeem.carmanagement.DataBase.UserDao;
import com.cseazeem.carmanagement.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Use JDBI to fetch user details
        User user = userDao.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Return a Spring Security User object
        return org.springframework.security.core.userdetails.User
                .withUsername(((User) user).getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}

