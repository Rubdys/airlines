package com.example.airport_backend.model.dto.converter.request_to_entity;

import com.example.airport_backend.model.dao.SeatEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.SeatRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatRequestToSeatEntity implements Convert<SeatRequest, SeatEntity> {
    @Override
    public SeatEntity convert(SeatRequest from) {
        SeatEntity toReturn = new SeatEntity();
        if(from.getAvailable()!=null) {
            toReturn.setAvailable(from.getAvailable());
        }
        toReturn.setSeatNumber(from.getSeatNumber());
        return toReturn;
    }

    @Override
    public List<SeatEntity> convert(List<SeatRequest> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(SeatRequest.class) && to.equals(SeatEntity.class);
    }
}
