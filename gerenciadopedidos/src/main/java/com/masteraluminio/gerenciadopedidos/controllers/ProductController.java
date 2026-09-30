package com.masteraluminio.gerenciadopedidos.controllers;

import com.masteraluminio.gerenciadopedidos.dtos.response.ProductDTO;
import com.masteraluminio.gerenciadopedidos.dtos.request.ProductPostRequest;
import com.masteraluminio.gerenciadopedidos.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getAll(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size){
       return ResponseEntity.ok().body(productService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> finById(@PathVariable Long id){
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ProductDTO > insert(@RequestBody ProductPostRequest request){
        ProductDTO obj = productService.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
