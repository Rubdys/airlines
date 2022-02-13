package com.example.airport_backend.model.dto.converter.entity_to_response;

import com.example.airport_backend.model.dao.UserEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserEntityToUserResponse implements Convert<UserEntity, UserResponse> {
    @Override
    public UserResponse convert(UserEntity from) {
        return UserResponse.builder()
                .id(from.getId())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .mail(from.getMail())
                .idCard(from.getIdCard())
                .build();
    }

    @Override
    public List<UserResponse> convert(List<UserEntity> from) {
        if(from.isEmpty()){
            return new ArrayList<>();
        }

        ArrayList<UserResponse> toReturn = new ArrayList<>();
        from.forEach(x-> toReturn.add(convert(x)));
        return toReturn;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(UserEntity.class) && to.equals(UserResponse.class);
    }
}
