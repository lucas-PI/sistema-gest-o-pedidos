package com.masteraluminio.gerenciadopedidos.dtos.exceptions;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends  CustomExceptionHandler{

    public ValidationError(OffsetDateTime timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    private List<FieldMessage> errorsAndField = new ArrayList<>();

    public List<FieldMessage> getErrorsAndField() {
        return errorsAndField;
    }

    public void addErrors(String fieldName, String message){
        errorsAndField.add(new FieldMessage(fieldName, message));
    }
}
