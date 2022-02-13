package com.example.airport_backend.model.dto.converter.entity_to_response;

import com.example.airport_backend.model.dao.SeatEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.response.SeatResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeatEntityToSeatResponse implements Convert<SeatEntity, SeatResponse> {

    @Override
    public SeatResponse convert(SeatEntity from) {
        return SeatResponse.builder()
                .id(from.getId())
                .build();
    }

    @Override
    public List<SeatResponse> convert(List<SeatEntity> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(SeatEntity.class) && to.equals(SeatResponse.class);
    }
}
