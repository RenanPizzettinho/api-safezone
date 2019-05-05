package com.stage.safezone.model.enums;

import com.stage.safezone.util.EnumConverter;

import javax.persistence.Converter;

public enum InscricaoStatus implements EnumType {

    CONFIRMADO("CO"),
    PENDENTE("PE"),
    CANCELADO("CA");

    private final String key;

    InscricaoStatus(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Converter(autoApply = true)
    public static final class InscricaoStatusConverter extends EnumConverter<InscricaoStatus> {
        public InscricaoStatusConverter() {
            super(InscricaoStatus.class);
        }
    }

}
