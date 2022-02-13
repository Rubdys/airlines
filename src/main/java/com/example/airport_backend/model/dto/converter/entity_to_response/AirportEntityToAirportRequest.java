package com.example.airport_backend.model.dto.converter.entity_to_response;

import com.example.airport_backend.model.dao.AirportEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.response.AirportResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirportEntityToAirportRequest implements Convert<AirportEntity, AirportResponse> {
    @Override
    public AirportResponse convert(AirportEntity from) {
        return AirportResponse.builder()
                .id(from.getId())
                .country(from.getCountry())
                .city(from.getCity())
                .name(from.getName())
                .build();
    }

    @Override
    public List<AirportResponse> convert(List<AirportEntity> from) {
        if(from.isEmpty()){
            return new ArrayList<>();
        }

        ArrayList<AirportResponse> toReturn = new ArrayList<>();
        from.forEach(x -> toReturn.add(convert(x)));
        return toReturn;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(AirportEntity.class) && to.equals(AirportResponse.class);
    }
}
