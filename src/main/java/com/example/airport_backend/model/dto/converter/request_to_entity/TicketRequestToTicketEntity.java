package com.example.airport_backend.model.dto.converter.request_to_entity;

import com.example.airport_backend.model.dao.TicketEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.TicketRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketRequestToTicketEntity implements Convert<TicketRequest, TicketEntity> {
    @Override
    public TicketEntity convert(TicketRequest from) {
        TicketEntity toReturn = new TicketEntity();
        return toReturn;
    }

    @Override
    public List<TicketEntity> convert(List<TicketRequest> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(TicketRequest.class) && to.equals(TicketEntity.class);
    }
}
