package com.stage.safezone.model.enums;

import com.stage.safezone.util.EnumConverter;

import javax.persistence.Converter;

public enum SituacaoEvento implements EnumType {

    EM_ABERTO("E", "Em aberto"),
    CANCELADO("C", "Cancelado"),
    FECHADO("F", "Fechado");


    private String key;
    private String description;

    SituacaoEvento(String key, String description) {
        this.key = key;
        this.description = description;
    }

    @Override
    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public SituacaoEvento getType() {
        return this;
    }


    @Converter(autoApply = true)
    public static final class SituacaoEventoConverter extends EnumConverter<SituacaoEvento> {
        public SituacaoEventoConverter() {
            super(SituacaoEvento.class);
        }
    }

}
