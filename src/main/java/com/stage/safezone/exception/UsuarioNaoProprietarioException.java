package com.stage.safezone.exception;

public class UsuarioNaoProprietarioException extends RuntimeException {

    public UsuarioNaoProprietarioException() {
        super("Você não pode alterar este item, pois não é o usuário responsavel por este.");
    }
}
