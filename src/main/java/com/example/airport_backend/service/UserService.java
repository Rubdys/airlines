package com.example.airport_backend.service;

import com.example.airport_backend.exception.ApplicationError;
import com.example.airport_backend.exception.ApplicationException;
import com.example.airport_backend.model.dao.UserEntity;
import com.example.airport_backend.model.dao.WalletEntity;
import com.example.airport_backend.model.dto.converter.Converter;
import com.example.airport_backend.model.dto.request.LoginRequest;
import com.example.airport_backend.model.dto.request.UserRequest;
import com.example.airport_backend.model.dto.response.UserResponse;
import com.example.airport_backend.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private Converter converter;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(Converter converter, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.converter = converter;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponse registerUser(UserRequest userRequest) {
        UserEntity toAdd = converter.convert(userRequest, UserEntity.class);
        WalletEntity wallet = new WalletEntity();
        wallet.setUser(toAdd);
        toAdd.setWallet(wallet);
        toAdd.setPassword(passwordEncoder.encode(toAdd.getPassword()));
        return converter.convert(userRepository.save(toAdd), UserResponse.class);
    }

    public UserResponse logIn(LoginRequest loginRequest) {
        Optional<UserEntity> user = userRepository.findByMail(loginRequest.getMail());
        if (user.orElseThrow(() -> new UsernameNotFoundException(String.format("User with mail %s not found", loginRequest.getMail())))
                .getPassword().equals(passwordEncoder.encode(loginRequest.getPassword()))) {
            return converter.convert(user.get(), UserResponse.class);
        }
        throw new ApplicationException(ApplicationError.WRONG_PASSWORD);
    }

    public List<UserResponse> getAll() {
        return converter.convert(converter.convert(userRepository.findAll(), UserEntity.class), UserResponse.class);
    }

    public Optional<UserEntity> findByMail(String mail){
        return userRepository.findByMail(mail);
    }
}
