package com.victor.HelpDesk.Resource.exception;

import com.victor.HelpDesk.Service.Exceptions.ObjectnotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ObjectnotFoundException.class)
    public ResponseEntity<StandardError>objectnotFoundException(ObjectnotFoundException ex,
     HttpServletRequest request) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), "Object Not Found", ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError>DataIntegrityViolationException(DataIntegrityViolationException ex,
     HttpServletRequest request) {

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Violação de dados" , ex.getMessage(), request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError>validationErrors(MethodArgumentNotValidException ex,
     HttpServletRequest request) {

       ValidationError errors = new  ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),"Erro na Validação do Campos","Validation error",
      request.getRequestURL());

       for (FieldError x : ex.getBindingResult().getFieldErrors()) {
           errors.addError(x.getField(), x.getDefaultMessage());
       }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}