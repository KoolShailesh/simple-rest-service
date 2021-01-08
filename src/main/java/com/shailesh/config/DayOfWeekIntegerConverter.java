package com.shailesh.config;

import java.time.DayOfWeek;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter 
public class DayOfWeekIntegerConverter implements AttributeConverter<DayOfWeek, Integer> {
    @Override
    public Integer convertToDatabaseColumn(DayOfWeek attribute) {
        System.err.println("converting dayofweek to int");
        return attribute.getValue() ;
    }

    @Override
    public DayOfWeek convertToEntityAttribute(Integer dbData) {
        System.err.println("converting int to dayofweek " + dbData);
        return DayOfWeek.of(dbData);
    }
}