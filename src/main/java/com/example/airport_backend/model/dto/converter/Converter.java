package com.example.airport_backend.model.dto.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Converter {

    private final List<Convert> converters;

    public <F, T> T convert(F fromObject, Class<T> to){
        for(Convert conv: converters){
            if(conv.canHandle(fromObject.getClass(), to.getClass())){
                return to.cast(conv.convert(fromObject));
            }
        }
        throw new UnsupportedOperationException();
    }

    public <F, T> List<T> convert(List<F> fromList, Class<T> to){
        if (fromList.isEmpty()) {
            return new ArrayList<>();
        }

        for(Convert conv: converters){
            if(conv.canHandle(fromList.get(0).getClass(), to.getClass())){
                return conv.convert(fromList);
            }
        }
        throw new UnsupportedOperationException();
    }
}
