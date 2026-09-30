package com.masteraluminio.gerenciadopedidos.repositories;

import com.masteraluminio.gerenciadopedidos.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
