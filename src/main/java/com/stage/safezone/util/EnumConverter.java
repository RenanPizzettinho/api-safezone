package com.stage.safezone.util;


import com.stage.safezone.model.enums.EnumType;

import javax.persistence.AttributeConverter;
import java.util.EnumSet;

public class EnumConverter<T extends Enum<T> & EnumType> implements AttributeConverter<T, String> {

    private final Class<T> enumClass;

    protected EnumConverter(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public String convertToDatabaseColumn(T attribute) {
        return (attribute == null) ? null : attribute.getKey();
    }

    @Override
    public T convertToEntityAttribute(String dbData) {
        for (T en : EnumSet.allOf(enumClass)) {
            if (en.getKey().equals(dbData))
                return en;
        }
        return null;
    }
}
