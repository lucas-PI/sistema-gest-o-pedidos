package com.masteraluminio.gerenciadopedidos.services.excptions;

public class DataBaseException extends RuntimeException {
    public DataBaseException(String message) {
        super(message);
    }
}
