package com.masteraluminio.gerenciadopedidos.dtos.response;

import com.masteraluminio.gerenciadopedidos.model.enums.ProgressStatus;
import com.masteraluminio.gerenciadopedidos.model.enums.StatusPriority;

import java.time.OffsetDateTime;

public class OrderDTO {

    private Long id;
    private String materCode;
    private String description;
    private Integer quantity;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private StatusPriority StatusPriority;
    private String observation;
    private ProgressStatus progressStatus;
    private UserDTO userDTO;



}
