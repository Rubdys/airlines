package com.example.airport_backend.model.dto.converter.entity_to_response;

import com.example.airport_backend.model.dao.TicketOwnerEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.response.TicketOwnerResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketOwnerEntityToTicketOwnerResponse implements Convert<TicketOwnerEntity, TicketOwnerResponse> {
    @Override
    public TicketOwnerResponse convert(TicketOwnerEntity from) {
        return TicketOwnerResponse.builder()
                .id(from.getId())
                .firstName(from.getFirstName())
                .lastName(from.getLastName())
                .idCard(from.getIdCard())
                .build();
    }

    @Override
    public List<TicketOwnerResponse> convert(List<TicketOwnerEntity> from) {
        if (from.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<TicketOwnerResponse> toReturn = new ArrayList<>();
        from.forEach(x -> toReturn.add(convert(x)));
        return toReturn;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(TicketOwnerEntity.class) && to.equals(TicketOwnerResponse.class);
    }
}
