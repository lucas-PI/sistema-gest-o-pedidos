package com.masteraluminio.gerenciadopedidos.controllers;

import com.masteraluminio.gerenciadopedidos.dtos.response.OrderDTO;
import com.masteraluminio.gerenciadopedidos.services.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    @GetMapping("/noFinish")
    public ResponseEntity<Page<OrderDTO>> findAllByProgressStatusNoFinish(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size){

        Page<OrderDTO> dtoPage = orderService.findAllByProgressStatusNoFinish(page,size);
        return ResponseEntity.ok().body(dtoPage);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO request){
        OrderDTO order = orderService.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(uri).body(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@RequestBody OrderDTO request, @PathVariable Long id){
         OrderDTO orderDTO = orderService.update(id, request);
         return ResponseEntity.ok(orderDTO);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
