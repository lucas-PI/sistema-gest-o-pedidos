package com.masteraluminio.gerenciadopedidos.model;

import com.masteraluminio.gerenciadopedidos.model.enums.ProgressStatus;
import com.masteraluminio.gerenciadopedidos.model.enums.StatusPriority;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String materCode;
    private String description;
    private Integer quantity;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime createdAt;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private StatusPriority StatusPriority;
    private String observation;
    @Enumerated(EnumType.STRING)
    private ProgressStatus progressStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> items = new HashSet<>();

    public Order(Long id, String materCode, String description, Integer quantity, OffsetDateTime createdAt, OffsetDateTime upadtedAt,
                 StatusPriority statusPriority, String observation, ProgressStatus progressStatus, User user) {
        this.id = id;
        this.materCode = materCode;
        this.description = description;
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.updatedAt = upadtedAt;
        this.StatusPriority = statusPriority;
        this.observation = observation;
        this.progressStatus = progressStatus;
        this.user = user;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterCode() {
        return materCode;
    }

    public void setMaterCode(String materCode) {
        this.materCode = materCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public StatusPriority getStatusPriority() {
        return StatusPriority;
    }

    public void setStatusPriority(StatusPriority statusPriority) {
        StatusPriority = statusPriority;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public ProgressStatus getProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(ProgressStatus progressStatus) {
        this.progressStatus = progressStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    @PrePersist
    public void dateCreatedAt(){
        setCreatedAt(OffsetDateTime.now());
    }

    @PostPersist
    public void updateLastPost(){
        setUpdatedAt(OffsetDateTime.now());
    }

    public List<Product> getProducts(){
        return items.stream().map(x -> x.getProduct()).toList();
    }
}
