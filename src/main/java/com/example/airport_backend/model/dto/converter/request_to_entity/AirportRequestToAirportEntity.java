package com.example.airport_backend.model.dto.converter.request_to_entity;

import com.example.airport_backend.model.dao.AirportEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.AirportRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirportRequestToAirportEntity implements Convert<AirportRequest, AirportEntity> {

    @Override
    public AirportEntity convert(AirportRequest from) {
        AirportEntity toReturn = new AirportEntity();
        toReturn.setCountry(from.getCountry());
        toReturn.setCity(from.getCity());
        toReturn.setName(from.getName());
        return toReturn;
    }

    @Override
    public List<AirportEntity> convert(List<AirportRequest> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(AirportRequest.class) && to.equals(AirportEntity.class);
    }
}
