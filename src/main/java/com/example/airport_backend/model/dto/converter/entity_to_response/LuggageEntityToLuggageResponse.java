package com.example.airport_backend.model.dto.converter.entity_to_response;

import com.example.airport_backend.model.dao.LuggageEntity;
import com.example.airport_backend.model.dto.converter.Convert;
import com.example.airport_backend.model.dto.response.LuggageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LuggageEntityToLuggageResponse implements Convert<LuggageEntity, LuggageResponse> {
    @Override
    public LuggageResponse convert(LuggageEntity from) {
        return LuggageResponse.builder()
                .id(from.getId())
                .luggageType(from.getLuggageType())
                .build();
    }

    @Override
    public List<LuggageResponse> convert(List<LuggageEntity> from) {
        return null;
    }

    @Override
    public <F, T> boolean canHandle(Class<F> from, Class<T> to) {
        return from.equals(LuggageEntity.class) && to.equals(LuggageResponse.class);
    }
}
