package com.masteraluminio.gerenciadopedidos.services;

import com.masteraluminio.gerenciadopedidos.dtos.response.ProductDTO;
import com.masteraluminio.gerenciadopedidos.dtos.request.ProductPostRequest;
import com.masteraluminio.gerenciadopedidos.model.Product;
import com.masteraluminio.gerenciadopedidos.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Transactional(readOnly = true)
    public Page<ProductDTO> getAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable).map(ProductDTO::toProductDTO);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        return ProductDTO.toProductDTO(productRepository.findById(id).get());
    }


    @Transactional
    public ProductDTO insert(ProductPostRequest request){
        return ProductDTO.toProductDTO(productRepository.save(Product.toProduct(request)));
    }

    @Transactional
    public ProductDTO update(){
        return null;
    }
}
