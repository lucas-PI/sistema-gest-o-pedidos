package com.masteraluminio.gerenciadopedidos.model.enums;

public enum StatusPriority {
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    URGENT(4);

    private int identify;
    StatusPriority(int identify){
        this.identify = identify;
    }
}
