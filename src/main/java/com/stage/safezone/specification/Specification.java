package com.stage.safezone.specification;


import com.stage.safezone.model.Entidade;

public abstract class Specification<T extends Entidade> {

    private String mensagem;

    protected abstract boolean validate(T entidade);

    protected void setMensagem(final String mensagem) {
        this.mensagem = mensagem;
    }

    protected String getMensagem() {
        return this.mensagem;
    }

}
