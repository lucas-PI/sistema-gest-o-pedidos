package com.masteraluminio.gerenciadopedidos.services.excptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Product with id: "+id+" not found");
    }
}
