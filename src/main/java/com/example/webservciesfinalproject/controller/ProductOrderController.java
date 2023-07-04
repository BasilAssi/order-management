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
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(tags = "Product Orders")
@RestController
@RequestMapping("/api/v1/customers/{customerId}/orders/{orderId}/products")
public class ProductOrderController {

    @Autowired
    private ProductOrderService productOrderService;


    // Get the products of a specific order
    @ApiOperation(value = "Get products of specific order")
    @GetMapping
    public ResponseEntity<List<ProductOrderDTO>> getProductsOfOrder(@PathVariable Integer customerId,@PathVariable Integer orderId) {
        return ResponseEntity.ok(productOrderService.getProductsOfOrder( customerId,orderId));
    }

    // Get a specific product of a specific order
    @ApiOperation(value = "Get specific product of specific order")
    @GetMapping("/{productId}")
    public ResponseEntity<ProductOrderDTO> getProductOfOrder( @PathVariable Integer customerId ,@PathVariable Integer orderId, @PathVariable Integer productId ) {
        return ResponseEntity.ok(productOrderService.getProductOfOrder(customerId,orderId, productId));
    }


    // Post a specific product to a specific order
    @ApiOperation(value = "Post specific product to specific order")
    @PostMapping
    public ResponseEntity<ProductOrderDTO> postProductToOrder( @PathVariable Integer customerId ,@PathVariable Integer orderId, @RequestBody ProductOrderDTO productOrderDTO) {
        return ResponseEntity.ok(productOrderService.addProductToOrder(customerId,orderId, productOrderDTO));
    }

    // Update a specific product of a specific order
    @ApiOperation(value = "Update specific product of specific order")
    @PutMapping("/{productId}")
    public ResponseEntity<ProductOrderDTO> updateProductOfOrder( @PathVariable Integer customerId , @PathVariable Integer orderId, @PathVariable Integer productId, @RequestBody ProductOrderDTO productOrderDTO) {
        return ResponseEntity.ok(productOrderService.updateProductOfOrder(customerId,orderId, productId, productOrderDTO));
    }

    // Delete a specific product of a specific order
    @ApiOperation(value = "Delete specific product of specific order")
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProductOfOrder( @PathVariable Integer customerId ,@PathVariable Integer orderId, @PathVariable Integer productId) {
        productOrderService.deleteProductOfOrder(customerId,orderId, productId);
        return ResponseEntity.ok().build();
    }

//    // Get the orders of a specific product
//    @ApiOperation(value = "Get orders of specific product")
//    @GetMapping("customers/{customerId}/products/{productId}/orders")
//    public ResponseEntity<List<ProductOrderDTO>> getOrdersOfProduct( @PathVariable Integer customerId ,@PathVariable Integer productId) {
//        return ResponseEntity.ok(productOrderService.getOrdersOfProduct(customerId,productId));
//    }
//
//    // Get a specific order of a specific product
//    @ApiOperation(value = "Get specific order of specific product")
//    @GetMapping("customers/{customerId}/products/{productId}/orders/{orderId}")
//    public ResponseEntity<ProductOrderDTO> getOrderOfProduct( @PathVariable Integer customerId ,@PathVariable Integer productId, @PathVariable Integer orderId) {
//        return ResponseEntity.ok(productOrderService.getOrderOfProduct(customerId,productId, orderId));
//    }
//
//    // Post a specific order to a specific product
//    @ApiOperation(value = "Post specific order to specific product")
//    @PostMapping("customers/{customerId}/products/{productId}/orders")
//    public ResponseEntity<ProductOrderDTO> postOrderToProduct( @PathVariable Integer customerId ,@PathVariable Integer productId, @RequestBody ProductOrderDTO productOrderDTO) {
//        return ResponseEntity.ok(productOrderService.addOrderToProduct(customerId,productId, productOrderDTO));
//    }
//
//    // Update a specific order of a specific product
//    @ApiOperation(value = "Update specific order of specific product")
//    @PutMapping("customers/{customerId}/products/{productId}/orders/{orderId}")
//    public ResponseEntity<ProductOrderDTO> updateOrderOfProduct( @PathVariable Integer customerId ,@PathVariable Integer productId, @PathVariable Integer orderId, @RequestBody ProductOrderDTO productOrderDTO) {
//        return ResponseEntity.ok(productOrderService.updateOrderOfProduct(customerId,productId, orderId, productOrderDTO));
//    }

    // Delete a specific order of a specific product
//    @ApiOperation(value = "Delete specific order of specific product")
//    @DeleteMapping("customers/{customerId}/products/{productId}/orders/{orderId}")
//    public ResponseEntity<Void> deleteOrderOfProduct( @PathVariable Integer customerId ,@PathVariable Integer productId, @PathVariable Integer orderId) {
//        productOrderService.deleteOrderOfProduct(customerId , productId, orderId);
//        return ResponseEntity.ok().build();
//    }
}