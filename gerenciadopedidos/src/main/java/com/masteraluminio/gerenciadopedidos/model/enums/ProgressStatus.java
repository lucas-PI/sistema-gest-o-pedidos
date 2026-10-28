package com.masteraluminio.gerenciadopedidos.model.enums;

public enum ProgressStatus {
    PENDING(1),
    IN_PROGRESS(2),
    DELIVERED(3),
    CANCELED(4);

    private int identity;
    ProgressStatus(int identity){
        this.identity = identity;
    }
}
