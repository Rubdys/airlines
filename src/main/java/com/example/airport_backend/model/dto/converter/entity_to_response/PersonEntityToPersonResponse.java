package com.example.airport_backend.model.dto.converter.entity_to_response;

import com.example.airport_backend.model.dao.PersonEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.PersonRequest;
import com.example.airport_backend.model.dto.response.PersonResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonEntityToPersonResponse implements Convert<PersonEntity, PersonResponse> {
    @Override
    public PersonResponse convert(PersonEntity from) {
        return PersonResponse.builder()
                .id(from.getId())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .idCard(from.getIdCard())
                .build();
    }

    @Override
    public List<PersonResponse> convert(List<PersonEntity> from) {
        ArrayList<PersonResponse> toReturn = new ArrayList<>();
        from.forEach(x -> toReturn.add(convert(x)));
        return toReturn;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(PersonEntity.class) && to.equals(PersonResponse.class);
    }
}
