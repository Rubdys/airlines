package com.example.airport_backend.model.dto.converter;

import java.util.List;

public interface Convert<F, T> {
    T convert(F from);
    List<T> convert(List<F> from);

    <F, T> boolean canHandle(Class<F> from, Class<T> to);
}
