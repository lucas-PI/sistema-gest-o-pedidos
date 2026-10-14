package com.masteraluminio.gerenciadopedidos.dtos.response;

import com.masteraluminio.gerenciadopedidos.model.Order;
import com.masteraluminio.gerenciadopedidos.model.OrderItem;
import com.masteraluminio.gerenciadopedidos.model.enums.ProgressStatus;
import com.masteraluminio.gerenciadopedidos.model.enums.StatusPriority;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

public class OrderDTO {

    private Long id;
    private String materCode;
    private String description;
    private Integer quantity;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String StatusPriority;
    private String observation;
    private String progressStatus;
    private UserDTO userDTO;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String materCode, String description, Integer quantity,
                    String statusPriority, String observation, String progressStatus, UserDTO userDTO) {
        this.id = id;
        this.materCode = materCode;
        this.description = description;
        this.quantity = quantity;
        StatusPriority = statusPriority;
        this.observation = observation;
        this.progressStatus = progressStatus;
        this.userDTO = userDTO;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.materCode = order.getMaterCode();
        this.description = order.getDescription();
        this.quantity = order.getQuantity();
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
        StatusPriority = order.getStatusPriority().toString();
        this.observation = order.getObservation();
        this.progressStatus = order.getProgressStatus().toString();
        this.userDTO = new UserDTO(order.getUser());
    }

    public Long getId() {
        return id;
    }

    public String getMaterCode() {
        return materCode;
    }

    public String getDescription() {
        return description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getStatusPriority() {
        return StatusPriority;
    }

    public String getObservation() {
        return observation;
    }

    public String getProgressStatus() {
        return progressStatus;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }
}
