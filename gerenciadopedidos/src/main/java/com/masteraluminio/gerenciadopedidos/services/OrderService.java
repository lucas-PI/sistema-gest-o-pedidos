package com.masteraluminio.gerenciadopedidos.services;

import com.masteraluminio.gerenciadopedidos.dtos.response.OrderDTO;
import com.masteraluminio.gerenciadopedidos.repositories.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Page<OrderDTO> findAll(int page, int size ){
        Pageable pageable = PageRequest.of(page,size);
        Page<OrderDTO> page1 =  orderRepository.findAll(pageable).map(o -> new OrderDTO(o));
        return page1;
    }
}
