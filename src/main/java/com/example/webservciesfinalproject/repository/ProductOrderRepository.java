/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/25/2023
 * Time: 2:15 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.repository;

import com.example.webservciesfinalproject.entity.ProductOrder;
import com.example.webservciesfinalproject.entity.ProductOrderKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderKey> {

    // Find all product orders by order ID
    List<ProductOrder> findByOrderId(Integer orderId);

    // Find all product orders by product ID
    List<ProductOrder> findByProductId(Integer productId);

    // Find a product order by order ID and product ID
    Optional<ProductOrder> findByOrderIdAndProductId(Integer orderId, Integer productId);

    // Delete a product order by order ID and product ID
    void deleteByOrderIdAndProductId(Integer orderId, Integer productId);
}