package com.victor.HelpDesk.Resource.exception;

import java.util.ArrayList;
import java.util.List;

/** @noinspection MissingSerialAnnotation*/
public class ValidationError extends StandardError {
    private static final long serialVersionUID = 1L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(long l, int value, String erroNaValidaçãoDoCampos, String message, StringBuffer requestURL) {
        super();
    }
    public ValidationError(Long timestamp, Integer status, String error, String message, String path) {
        super(timestamp, status, error, message, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }
    public void addError(String fieldName, String message){
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
