package com.example.airport_backend.config;

import com.example.airport_backend.model.dao.UserEntity;
import com.example.airport_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        UserEntity user = userService.findByMail(mail).orElseThrow(() -> new UsernameNotFoundException(String.format("User with mail %s not found", mail)));

        return User.builder()
                .username(user.getMail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }
}
