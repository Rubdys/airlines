package com.example.airport_backend.model.dto.converter.request_to_entity;

import com.example.airport_backend.model.dao.LuggageEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.request.LuggageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LuggageRequestToLuggageEntity implements Convert<LuggageRequest, LuggageEntity> {
    @Override
    public LuggageEntity convert(LuggageRequest from) {
        LuggageEntity toReturn = new LuggageEntity();
        toReturn.setLuggageType(from.getLuggageType());
        return toReturn;
    }

    @Override
    public List<LuggageEntity> convert(List<LuggageRequest> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(LuggageRequest.class) && to.equals(LuggageEntity.class);
    }
}
