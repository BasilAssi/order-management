package com.example.webservciesfinalproject.service;

import com.example.webservciesfinalproject.dto.ProductOrderDTO;

import java.util.List;

public interface ProductOrderService {

    List<ProductOrderDTO> getProductsOfOrder(Integer orderId);

    ProductOrderDTO getProductOfOrder(Integer orderId, Integer productId);

    ProductOrderDTO addProductToOrder(Integer orderId, ProductOrderDTO productOrderDTO);

    ProductOrderDTO updateProductOfOrder(Integer orderId, Integer productId, ProductOrderDTO productOrderDTO);

    void deleteProductOfOrder(Integer orderId, Integer productId);

    List<ProductOrderDTO> getOrdersOfProduct(Integer productId);

    ProductOrderDTO getOrderOfProduct(Integer productId, Integer orderId);

    ProductOrderDTO addOrderToProduct(Integer productId, ProductOrderDTO productOrderDTO);

    ProductOrderDTO updateOrderOfProduct(Integer productId, Integer orderId, ProductOrderDTO productOrderDTO);

    void deleteOrderOfProduct(Integer productId, Integer orderId);
}
