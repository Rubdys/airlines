package com.example.airport_backend.model.dto.converter.entity_to_response;

import com.example.airport_backend.model.dao.FlightEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.response.FlightResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightEntityToFlightResponse implements Convert<FlightEntity, FlightResponse> {
    @Override
    public FlightResponse convert(FlightEntity from) {
        return FlightResponse.builder()
                .departureTime(from.getDepartureTime())
                .arrivalTime(from.getArrivalTime())
                .build();
    }

    @Override
    public List<FlightResponse> convert(List<FlightEntity> from) {
        List<FlightResponse> toReturn = new ArrayList<>();
        from.forEach(x -> toReturn.add(convert(x)));
        return toReturn;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(FlightEntity.class) && to.equals(FlightResponse.class);
    }
}
