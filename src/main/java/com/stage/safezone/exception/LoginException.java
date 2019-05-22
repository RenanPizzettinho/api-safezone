package com.stage.safezone.exception;

public class LoginException extends RuntimeException {

    public LoginException() {
        super("Erro ao realizar o login");
    }

    public LoginException(final String message) {
        super(message);
    }

}
