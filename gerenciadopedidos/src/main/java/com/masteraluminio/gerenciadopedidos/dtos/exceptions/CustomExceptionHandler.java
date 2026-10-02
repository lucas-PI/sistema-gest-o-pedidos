package com.masteraluminio.gerenciadopedidos.dtos.exceptions;

import java.time.OffsetDateTime;

public class CustomExceptionHandler {
    private OffsetDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomExceptionHandler(OffsetDateTime timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }


    public Integer getStatus() {
        return status;
    }


    public String getError() {
        return error;
    }


    public String getPath() {
        return path;
    }

}
