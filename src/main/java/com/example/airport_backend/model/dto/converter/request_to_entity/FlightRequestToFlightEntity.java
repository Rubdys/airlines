package com.example.airport_backend.model.dto.converter.request_to_entity;

import com.example.airport_backend.model.dao.FlightEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.FlightRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlightRequestToFlightEntity implements Convert<FlightRequest, FlightEntity> {
    @Override
    public FlightEntity convert(FlightRequest from) {
        FlightEntity toReturn = new FlightEntity();
        toReturn.setArrivalTime(from.getArrivalTime());
        toReturn.setDepartureTime(from.getDepartureTime());
        return toReturn;
    }

    @Override
    public List<FlightEntity> convert(List<FlightRequest> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(FlightRequest.class) && to.equals(FlightEntity.class);
    }
}
