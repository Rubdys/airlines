package com.example.airport_backend.model.dto.converter.request_to_entity;

import com.example.airport_backend.model.dao.TicketOwnerEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.TicketOwnerRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketOwnerRequestToTicketOwnerEntity implements Convert<TicketOwnerRequest, TicketOwnerEntity> {
    @Override
    public TicketOwnerEntity convert(TicketOwnerRequest from) {
        TicketOwnerEntity toReturn = new TicketOwnerEntity();
        toReturn.setFirstName(from.getFirstName());
        toReturn.setLastName(from.getLastName());
        toReturn.setIdCard(from.getIdCard());
        return toReturn;
    }

    @Override
    public List<TicketOwnerEntity> convert(List<TicketOwnerRequest> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(TicketOwnerRequest.class) && to.equals(TicketOwnerEntity.class);
    }
}
