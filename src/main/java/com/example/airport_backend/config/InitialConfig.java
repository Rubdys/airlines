package com.example.airport_backend.config;

import com.example.airport_backend.model.dao.RoleEntity;
import com.example.airport_backend.model.dao.UserEntity;
import com.example.airport_backend.repository.RoleRepository;
import com.example.airport_backend.repository.UserRepository;
import com.example.airport_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InitialConfig implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Optional<UserEntity> check = userService.findByMail("admin@admin.com");
        if(check.isEmpty()){
            RoleEntity roleUser = new RoleEntity();
            roleUser.setRole("USER");
            if(roleRepository.findByRole(roleUser.getRole()).isEmpty()){
                roleRepository.save(roleUser);
            }

            RoleEntity roleAdmin = new RoleEntity();
            roleAdmin.setRole("ADMIN");
            if(roleRepository.findByRole(roleAdmin.getRole()).isEmpty()){
                roleRepository.save(roleAdmin);
            }




            UserEntity admin = new UserEntity();
            admin.setMail("admin@admin.com");
            admin.setPassword(passwordEncoder.encode("admin"));

            List<RoleEntity> list = new ArrayList();
            list.add(roleRepository.findByRole("ADMIN").get());

            admin.setRoles(list);
            userRepository.save(admin);
        }
    }
}
