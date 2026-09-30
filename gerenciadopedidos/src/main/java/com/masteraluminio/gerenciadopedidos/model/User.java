package com.masteraluminio.gerenciadopedidos.model;

import com.masteraluminio.gerenciadopedidos.model.enums.TipoUser;
import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private TipoUser type;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime createAt;
    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private OffsetDateTime UpdateAt;
    @OneToMany(mappedBy = "user")
    List<Order> orderList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUser getType() {
        return type;
    }

    public void setType(TipoUser type) {
        this.type = type;
    }

    public OffsetDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(OffsetDateTime createAt) {
        this.createAt = createAt;
    }

    public OffsetDateTime getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(OffsetDateTime updateAt) {
        UpdateAt = updateAt;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    @PrePersist
    public void dateCreatedAt(){
        setCreateAt(OffsetDateTime.now());
    }

    @PostPersist
    public void updateLastPost(){
        setUpdateAt(OffsetDateTime.now());
    }

}
