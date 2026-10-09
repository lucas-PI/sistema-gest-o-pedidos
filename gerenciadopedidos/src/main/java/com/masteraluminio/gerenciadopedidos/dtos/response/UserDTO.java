package com.masteraluminio.gerenciadopedidos.dtos.response;

import com.masteraluminio.gerenciadopedidos.model.User;
import com.masteraluminio.gerenciadopedidos.model.enums.TipoUser;

import java.util.Locale;

public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private TipoUser type;

    public UserDTO(String name, String password, String type) {
        this.name = name;
        this.password = password;
        this.type = TipoUser.valueOf(type.toUpperCase(Locale.ROOT).trim());
    }

    public UserDTO() {
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.type = entity.getType();}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public TipoUser getType() {
        return type;
    }
}
