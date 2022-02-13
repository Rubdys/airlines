package com.example.airport_backend.model.dto.converter.request_to_entity;

import com.example.airport_backend.model.dao.PersonEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.PersonRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonRequestToPersonEntity implements Convert<PersonRequest, PersonEntity> {
    @Override
    public PersonEntity convert(PersonRequest from) {
        PersonEntity toReturn = new PersonEntity();
        toReturn.setFirstName(from.getFirstName());
        toReturn.setLastName(from.getLastName());
        toReturn.setIdCard(from.getIdCard());
        return toReturn;
    }

    @Override
    public List<PersonEntity> convert(List<PersonRequest> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(PersonRequest.class) && to.equals(PersonEntity.class);
    }
}
