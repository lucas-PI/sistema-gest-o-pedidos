package com.masteraluminio.gerenciadopedidos.dtos.response;

import com.masteraluminio.gerenciadopedidos.model.Category;
import com.masteraluminio.gerenciadopedidos.model.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO{

    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    private Set<CategoryDTO> categoryDTOS = new HashSet<>();

    public ProductDTO(Long id, String name, String description, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity){
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        imgUrl = entity.getImgUrl();
        for(Category cat : entity.getCategories()){
            categoryDTOS.add(new CategoryDTO(cat));
        }
    }

    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getImgUrl());
    }



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Set<CategoryDTO> getCategoryDTOS() {
        return categoryDTOS;
    }
}
