package com.example.airport_backend.model.dto.converter.request_to_entity;

import com.example.airport_backend.model.dao.AirplaneEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.AirplaneRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirplaneRequestToAirplaneEntity implements Convert<AirplaneRequest, AirplaneEntity> {
    @Override
    public AirplaneEntity convert(AirplaneRequest from) {
        AirplaneEntity toReturn = new AirplaneEntity();
//        toReturn.setAirplaneModel(from.getAirplaneModel());
        return toReturn;
    }

    @Override
    public List<AirplaneEntity> convert(List<AirplaneRequest> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(AirplaneRequest.class) && to.equals(AirplaneEntity.class);
    }
}
