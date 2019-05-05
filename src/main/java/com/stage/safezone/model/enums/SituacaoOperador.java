package com.stage.safezone.model.enums;

import com.stage.safezone.util.EnumConverter;

import javax.persistence.Converter;

public enum SituacaoOperador implements EnumType {

    OPERANDO("O", "Operando"),
    DESVINCULADO("D", "Desvinculado");

    private String key;
    private String description;

    SituacaoOperador(String key, String description) {
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

    @Converter(autoApply = true)
    public static final class SituacaoOperadorConverter extends EnumConverter<SituacaoOperador> {
        public SituacaoOperadorConverter() {
            super(SituacaoOperador.class);
        }
    }

}
