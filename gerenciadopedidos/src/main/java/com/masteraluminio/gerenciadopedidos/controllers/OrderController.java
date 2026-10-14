package com.masteraluminio.gerenciadopedidos.controllers;

import com.masteraluminio.gerenciadopedidos.dtos.response.OrderDTO;
import com.masteraluminio.gerenciadopedidos.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<Page<OrderDTO>> findAll(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size){
        Page<OrderDTO> dtoPage = orderService.findAll(page,size);
        return ResponseEntity.ok().body(dtoPage);
    }
}
