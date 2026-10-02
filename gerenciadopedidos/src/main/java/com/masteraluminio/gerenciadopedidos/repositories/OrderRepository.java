package com.masteraluminio.gerenciadopedidos.repositories;

import com.masteraluminio.gerenciadopedidos.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
