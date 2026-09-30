package com.masteraluminio.gerenciadopedidos.model.enums;

public enum TipoUser {
    LOGISTICA(1),
    EXPEDICAO(2);

    private int identification;

    TipoUser(int identification){
        this.identification = identification;
    }
}
