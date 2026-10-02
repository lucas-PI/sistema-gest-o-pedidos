package com.masteraluminio.gerenciadopedidos.services;

import com.masteraluminio.gerenciadopedidos.dtos.request.ProductPutRequest;
import com.masteraluminio.gerenciadopedidos.dtos.response.ProductDTO;
import com.masteraluminio.gerenciadopedidos.dtos.request.ProductPostRequest;
import com.masteraluminio.gerenciadopedidos.model.Product;
import com.masteraluminio.gerenciadopedidos.repositories.ProductRepository;
import com.masteraluminio.gerenciadopedidos.services.excptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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
        return ProductDTO.toProductDTO(productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id)));
    }


    @Transactional
    public ProductDTO insert(ProductPostRequest request){
        return ProductDTO.toProductDTO(productRepository.save(Product.toProduct(request)));
    }

    @Transactional
    public ProductDTO update(Long id, ProductPutRequest request){
        // process of update product record
        Product productToUpdate = productRepository.findById(id).get();
        Optional.ofNullable(request.getName()).ifPresent(productToUpdate::setName);
        Optional.ofNullable(request.getDescription()).ifPresent(productToUpdate::setDescription);
        Optional.ofNullable(productToUpdate.getImgUrl()).ifPresent(productToUpdate::setDescription);

        return ProductDTO.toProductDTO(productRepository.save(productToUpdate));
    }

    @Transactional
    public void delete(Long id){
        try{
        productRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException | DataIntegrityViolationException e){
            throw new ResourceNotFoundException(id);
        }
    }
}
