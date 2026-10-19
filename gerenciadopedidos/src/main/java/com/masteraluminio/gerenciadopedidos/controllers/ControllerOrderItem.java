package com.masteraluminio.gerenciadopedidos.controllers;

import com.masteraluminio.gerenciadopedidos.model.OrderItem;
import com.masteraluminio.gerenciadopedidos.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderitens")
public class ControllerOrderItem {

    private final OrderService orderService;

    public ControllerOrderItem(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderItem insert(){
        return null;
    }
}
