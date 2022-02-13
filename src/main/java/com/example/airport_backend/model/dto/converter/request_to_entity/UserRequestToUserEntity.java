package com.example.airport_backend.model.dto.converter.request_to_entity;


import com.example.airport_backend.model.dao.UserEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.UserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRequestToUserEntity implements Convert<UserRequest, UserEntity> {

    private PasswordEncoder passwordEncoder;

    public UserRequestToUserEntity(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity convert(UserRequest from) {
        UserEntity toReturn = new UserEntity();
        toReturn.setFirstName(from.getFirstName());
        toReturn.setLastName(from.getLastName());
        toReturn.setMail(from.getMail());
        toReturn.setPassword(passwordEncoder.encode(from.getPassword()));
        toReturn.setIdCard(from.getIdCard());
        return toReturn;
    }

    @Override
    public List<UserEntity> convert(List<UserRequest> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(UserRequest.class) && to.equals(UserEntity.class);
    }
}
