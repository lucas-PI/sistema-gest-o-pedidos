package com.masteraluminio.gerenciadopedidos.model.enums;

public enum ProgressStatus {
    PENDING(1),
    IN_PROGRESS(2),
    DELIVERED(3);

    private int identity;
    ProgressStatus(int identity){
        this.identity = identity;
    }
}
