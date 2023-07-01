/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/28/2023
 * Time: 11:24 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.controller;

import com.example.webservciesfinalproject.dto.ProductOrderDTO;
import com.example.webservciesfinalproject.service.ProductOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Product Orders")
@RestController
@RequestMapping("/api")
public class ProductOrderController {

    @Autowired
    private ProductOrderService productOrderService;

    // Get the products of a specific order
    @ApiOperation(value = "Get products of specific order")
    @GetMapping("/orders/{orderId}/products")
    public ResponseEntity<List<ProductOrderDTO>> getProductsOfOrder(@PathVariable Integer orderId) {
        return ResponseEntity.ok(productOrderService.getProductsOfOrder(orderId));
    }

    // Get a specific product of a specific order
    @ApiOperation(value = "Get specific product of specific order")
    @GetMapping("/orders/{orderId}/products/{productId}")
    public ResponseEntity<ProductOrderDTO> getProductOfOrder(@PathVariable Integer orderId, @PathVariable Integer productId) {
        return ResponseEntity.ok(productOrderService.getProductOfOrder(orderId, productId));
    }

    // Post a specific product to a specific order
    @ApiOperation(value = "Post specific product to specific order")
    @PostMapping("/orders/{orderId}/products")
    public ResponseEntity<ProductOrderDTO> postProductToOrder(@PathVariable Integer orderId, @RequestBody ProductOrderDTO productOrderDTO) {
        return ResponseEntity.ok(productOrderService.addProductToOrder(orderId, productOrderDTO));
    }

    // Update a specific product of a specific order
    @ApiOperation(value = "Update specific product of specific order")
    @PutMapping("/orders/{orderId}/products/{productId}")
    public ResponseEntity<ProductOrderDTO> updateProductOfOrder(@PathVariable Integer orderId, @PathVariable Integer productId, @RequestBody ProductOrderDTO productOrderDTO) {
        return ResponseEntity.ok(productOrderService.updateProductOfOrder(orderId, productId, productOrderDTO));
    }

    // Delete a specific product of a specific order
    @ApiOperation(value = "Delete specific product of specific order")
    @DeleteMapping("/orders/{orderId}/products/{productId}")
    public ResponseEntity<Void> deleteProductOfOrder(@PathVariable Integer orderId, @PathVariable Integer productId) {
        productOrderService.deleteProductOfOrder(orderId, productId);
        return ResponseEntity.ok().build();
    }

    // Get the orders of a specific product
    @ApiOperation(value = "Get orders of specific product")
    @GetMapping("/products/{productId}/orders")
    public ResponseEntity<List<ProductOrderDTO>> getOrdersOfProduct(@PathVariable Integer productId) {
        return ResponseEntity.ok(productOrderService.getOrdersOfProduct(productId));
    }

    // Get a specific order of a specific product
    @ApiOperation(value = "Get specific order of specific product")
    @GetMapping("/products/{productId}/orders/{orderId}")
    public ResponseEntity<ProductOrderDTO> getOrderOfProduct(@PathVariable Integer productId, @PathVariable Integer orderId) {
        return ResponseEntity.ok(productOrderService.getOrderOfProduct(productId, orderId));
    }

    // Post a specific order to a specific product
    @ApiOperation(value = "Post specific order to specific product")
    @PostMapping("/products/{productId}/orders")
    public ResponseEntity<ProductOrderDTO> postOrderToProduct(@PathVariable Integer productId, @RequestBody ProductOrderDTO productOrderDTO) {
        return ResponseEntity.ok(productOrderService.addOrderToProduct(productId, productOrderDTO));
    }

    // Update a specific order of a specific product
    @ApiOperation(value = "Update specific order of specific product")
    @PutMapping("/products/{productId}/orders/{orderId}")
    public ResponseEntity<ProductOrderDTO> updateOrderOfProduct(@PathVariable Integer productId, @PathVariable Integer orderId, @RequestBody ProductOrderDTO productOrderDTO) {
        return ResponseEntity.ok(productOrderService.updateOrderOfProduct(productId, orderId, productOrderDTO));
    }

    // Delete a specific order of a specific product
    @ApiOperation(value = "Delete specific order of specific product")
    @DeleteMapping("/products/{productId}/orders/{orderId}")
    public ResponseEntity<Void> deleteOrderOfProduct(@PathVariable Integer productId, @PathVariable Integer orderId) {
        productOrderService.deleteOrderOfProduct(productId, orderId);
        return ResponseEntity.ok().build();
    }
}