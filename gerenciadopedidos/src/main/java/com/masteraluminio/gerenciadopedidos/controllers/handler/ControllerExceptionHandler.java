package com.masteraluminio.gerenciadopedidos.controllers.handler;

import com.masteraluminio.gerenciadopedidos.dtos.exceptions.CustomExceptionHandler;
import com.masteraluminio.gerenciadopedidos.dtos.exceptions.ValidationError;
import com.masteraluminio.gerenciadopedidos.services.excptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomExceptionHandler> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        CustomExceptionHandler err = new CustomExceptionHandler(OffsetDateTime.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomExceptionHandler> methodArgumentNotValidation(MethodArgumentNotValidException e,
                                                                              HttpServletRequest request){
        HttpStatus status = HttpStatus.UNPROCESSABLE_CONTENT;
        ValidationError err = new ValidationError(OffsetDateTime.now(), status.value(), "campos(s) inválido(s)", request.getRequestURI());

        for (FieldError f :e.getBindingResult().getFieldErrors()){
            err.addErrors(f.getField(),f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }
}
