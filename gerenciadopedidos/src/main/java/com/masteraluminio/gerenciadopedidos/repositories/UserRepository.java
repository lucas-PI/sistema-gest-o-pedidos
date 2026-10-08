package com.masteraluminio.gerenciadopedidos.repositories;

import com.masteraluminio.gerenciadopedidos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
