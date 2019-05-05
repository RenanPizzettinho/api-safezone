package com.stage.safezone.model.enums;

import com.stage.safezone.util.EnumConverter;

import javax.persistence.Converter;

public enum SituacaoSolicitacao implements EnumType {

    PENDENTE("P", "Pendente"),
    APROVADA("A", "Aprovada"),
    NEGADA("N", "Negada");

    private String key;
    private String description;

    SituacaoSolicitacao(String key, String description) {
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
    public static final class SituacaoSolicitacaoConverter extends EnumConverter<SituacaoSolicitacao> {
        public SituacaoSolicitacaoConverter() {
            super(SituacaoSolicitacao.class);
        }
    }

}
