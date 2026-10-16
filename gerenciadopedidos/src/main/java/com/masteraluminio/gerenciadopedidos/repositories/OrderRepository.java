package com.masteraluminio.gerenciadopedidos.repositories;

import com.masteraluminio.gerenciadopedidos.model.Order;
import com.masteraluminio.gerenciadopedidos.model.enums.ProgressStatus;
import org.hibernate.validator.internal.metadata.provider.ProgrammaticMetaDataProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Page<Order> findAllByProgressStatusIn(List<ProgressStatus> status, Pageable pageable);
}
