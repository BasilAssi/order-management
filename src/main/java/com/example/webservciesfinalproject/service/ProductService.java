package com.example.webservciesfinalproject.service;

import com.example.webservciesfinalproject.dto.ProductDTO;

import java.util.List;


public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Integer id);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Integer id, ProductDTO productDTO);
    void deleteProduct(Integer id);
}