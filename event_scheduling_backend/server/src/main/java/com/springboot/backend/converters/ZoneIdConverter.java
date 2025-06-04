package com.springboot.backend.converters;

import jakarta.persistence.AttributeConverter;

import java.time.ZoneId;

public class ZoneIdConverter implements AttributeConverter<ZoneId, String> {
    @Override
    public String convertToDatabaseColumn(ZoneId attribute) { return attribute == null ? null : attribute.getId(); }

    @Override
    public ZoneId convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return ZoneId.of(dbData);
    }
}
