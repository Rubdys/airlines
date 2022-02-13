package com.example.airport_backend.model.dto.converter.entity_to_response;

import com.example.airport_backend.model.dao.AirplaneEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.response.AirplaneResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AirplaneEntityToAirplaneResponse implements Convert<AirplaneEntity, AirplaneResponse> {
    @Override
    public AirplaneResponse convert(AirplaneEntity from) {
        return AirplaneResponse.builder()
                .id(from.getId())
//                .airplaneModel(from.getAirplaneModel())
                .build();
    }

    @Override
    public List<AirplaneResponse> convert(List<AirplaneEntity> from) {
        if(from.isEmpty()){
            return new ArrayList<>();
        }

        ArrayList<AirplaneResponse> toReturn = new ArrayList<>();
        from.forEach(x -> toReturn.add(convert(x)));
        return toReturn;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(AirplaneEntity.class) && to.equals(AirplaneResponse.class);
    }
}
