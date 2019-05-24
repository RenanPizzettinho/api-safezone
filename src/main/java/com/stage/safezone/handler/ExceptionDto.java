package com.stage.safezone.handler;

import java.io.Serializable;

public class ExceptionDto implements Serializable {

    private final String mensagem;

    public ExceptionDto(final String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
