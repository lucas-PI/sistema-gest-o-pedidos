package com.masteraluminio.gerenciadopedidos.dtos.response;

import com.masteraluminio.gerenciadopedidos.model.Order;
import com.masteraluminio.gerenciadopedidos.model.enums.StatusPriority;

import java.time.OffsetDateTime;
import java.util.Locale;

public class OrderDTO {

    private Long id;
    private String description;
    private Integer quantity;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private StatusPriority statusPriority;
    private String observation;
    private String progressStatus;
    private Long idUser;

    public OrderDTO() {
    }

    public OrderDTO(Long id, String description, Integer quantity,
                    String statusPriority, String observation, String progressStatus,Long idUser) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.statusPriority = StatusPriority.valueOf(statusPriority.toUpperCase(Locale.ROOT).trim());
        this.observation = observation;
        this.progressStatus = progressStatus;
        this.idUser = idUser;
    }

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.description = order.getDescription();
        this.quantity = order.getQuantity();
        this.createdAt = order.getCreatedAt();
        this.updatedAt = order.getUpdatedAt();
        statusPriority = order.getStatusPriority();
        this.observation = order.getObservation();
        this.progressStatus = order.getProgressStatus().toString();
        idUser = order.getUser().getId();
    }

    public Long getId() {
        return id;
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

    public StatusPriority getStatusPriority() {
        return statusPriority;
    }

    public String getObservation() {
        return observation;
    }

    public String getProgressStatus() {
        return progressStatus;
    }

    public Long getIdUser() {
        return idUser;
    }
}
