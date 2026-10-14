package com.masteraluminio.gerenciadopedidos.dtos.response;

import com.masteraluminio.gerenciadopedidos.model.Order;
import com.masteraluminio.gerenciadopedidos.model.User;
import com.masteraluminio.gerenciadopedidos.model.enums.TipoUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDTO {
    private Long id;
    private String name;
    private String password;
    private TipoUser type;
    private List<OrderDTO> orderDTOS = new ArrayList<>();

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
        this.type = entity.getType();
        for(Order order: entity.getOrderList()){
            orderDTOS.add(new OrderDTO(order));
        }
    }


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

    public List<OrderDTO> getOrderDTOS() {
        return orderDTOS;
    }
}
