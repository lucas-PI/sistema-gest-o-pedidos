package com.masteraluminio.gerenciadopedidos.dtos.response;

import com.masteraluminio.gerenciadopedidos.model.Product;

public class ProductDTO{

    private Long id;
    private String name;
    private String description;
    private String imgUrl;

    public ProductDTO(Long id, String name, String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getImgUrl());
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
