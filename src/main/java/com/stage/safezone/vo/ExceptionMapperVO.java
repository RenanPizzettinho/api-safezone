package com.stage.safezone.vo;

public class ExceptionMapperVO {

    private String exception;
    private String message;

    public ExceptionMapperVO() {
    }

    public ExceptionMapperVO(String exception, String message) {
        this.exception = exception;
        this.message = message;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
