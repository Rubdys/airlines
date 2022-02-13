package com.example.airport_backend.controller;

import com.example.airport_backend.model.dto.request.UserRequest;
import com.example.airport_backend.model.dto.response.UserResponse;
import com.example.airport_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/users/register")
    public UserResponse registerUser(@RequestBody UserRequest userRequest){
        return userService.registerUser(userRequest);
    }

    @GetMapping(path = "/users/login")
    public UserResponse logIn(@RequestBody UserRequest userRequest){
        return userService.logIn(userRequest);
    }

    @GetMapping(path = "/users/all")
    public List<UserResponse> getAll(){
        return userService.getAll();
    }
}
