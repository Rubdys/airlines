package com.example.airport_backend.model.dto.converter.entity_to_response;

import com.example.airport_backend.model.dao.TicketEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.response.TicketResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketEntityToTicketResponse implements Convert<TicketEntity, TicketResponse> {
    @Override
    public TicketResponse convert(TicketEntity from) {
        return TicketResponse.builder()
                .id(from.getId())
                .build();
    }

    @Override
    public List<TicketResponse> convert(List<TicketEntity> from) {
        if(from.isEmpty()){
            return new ArrayList<>();
        }

        ArrayList<TicketResponse> toReturn= new ArrayList<>();
        from.forEach(x -> toReturn.add(convert(x)));
        return toReturn;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(TicketEntity.class) && to.equals(TicketResponse.class);
    }
}
