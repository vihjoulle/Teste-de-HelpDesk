package com.victor.HelpDesk.Service.Exceptions;

public class ObjectnotFoundException extends RuntimeException{
    private static final Long serialVersionUID = 1L;

    public ObjectnotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectnotFoundException(String message) {
        super(message);
    }


}
