package com.enigma.reimbursment.online.models.convertes;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
public class DirectionConverter implements Converter<String, Direction> {
    @Override
    public Direction convert(String source) {
        return Direction
                .fromOptionalString(source.toUpperCase())
                .orElseThrow();
    }
}
