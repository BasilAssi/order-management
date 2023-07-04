/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 7/1/2023
 * Time: 9:00 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.controller;


import com.example.webservciesfinalproject.dto.CustomerDTO;
import com.example.webservciesfinalproject.dto.OrderDTO;
import com.example.webservciesfinalproject.dto.ProductDTO;
import com.example.webservciesfinalproject.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
// This class is annotated with @RestController, signifying that it is a controller that should handle HTTP requests in a RESTful web service.
// The @RequestMapping annotation maps this controller to the "/api/v1/products" path.

@Api(tags = "Products")
@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    // This is a dependency on a service class that is used to process business-level operations.
    private final ProductService productService;

    @ApiOperation(value = "Get  All Products by Admin")
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {

        List<ProductDTO> productDTOS=productService.getAllProducts();

        for ( ProductDTO product: productDTOS ) {
            Link stocksLink = linkTo(methodOn(StockController.class)
                    .getAllStocksByProductId(product.getId()))
                    .withRel("Stocks ");
            product.add(stocksLink);
        }
        // The products, along with their respective links, are returned.
        return ResponseEntity.ok(productDTOS);
        //return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    // This method fetches a specific product by its id.
    @ApiOperation(value = "Get  Product by Id ,  by Admin")
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id) {
        ProductDTO productDTO = productService.getProductById(id);
        if (productDTO != null) {
            Link stockLink = linkTo(methodOn(StockController.class)
                    .getAllStocksByProductId(productDTO.getId()))
                    .withRel("Stocks ");
            productDTO.add(stockLink);
            return ResponseEntity.ok(productDTO);
        } else { // If the product does not exist, a HTTP 404 status code is returned.
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @ApiOperation(value = "Post  Product by Id ,  by Admin")
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update   Product by Id ,  by Admin")
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        ProductDTO updatedProductDTO = productService.updateProduct(id, productDTO);
        if (updatedProductDTO != null) {
            return new ResponseEntity<>(updatedProductDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @ApiOperation(value = "Delete   Product by Id ,  by Admin")
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }


}