/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/28/2023
 * Time: 11:36 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.controller;

import com.example.webservciesfinalproject.dto.StockDTO;
import com.example.webservciesfinalproject.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Stock")
@RestController
@RequestMapping("/api/products")
public class StockController {

    @Autowired
    private StockService stockService;

    @ApiOperation(value = "Get all stocks of a specific product")
    @GetMapping("/{productId}/stocks")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<List<StockDTO>> getAllStocksByProductId(@PathVariable Integer productId) {
        return ResponseEntity.ok(stockService.getAllStocksByProductId(productId));
    }

    @ApiOperation(value = "Get specific stock by stock ID of a specific product")
    @GetMapping("/{productId}/stocks/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<StockDTO> getStockByProductIdAndStockId(@PathVariable Integer productId, @PathVariable Integer id) {
        return ResponseEntity.ok(stockService.getStockByProductIdAndStockId(productId, id));
    }

    @ApiOperation(value = "Create a new stock entry for a specific product")
    @PostMapping("/{productId}/stocks")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StockDTO> createStockByProductId(@PathVariable Integer productId, @RequestBody StockDTO stockDTO) {
        return ResponseEntity.ok(stockService.createStockByProductId(productId, stockDTO));
    }

    @ApiOperation(value = "Update stock for a specific product")
    @PutMapping("/{productId}/stocks/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StockDTO> updateStockByProductIdAndStockId(@PathVariable Integer productId, @PathVariable Integer id, @RequestBody StockDTO stockDTO) {
        return ResponseEntity.ok(stockService.updateStockByProductIdAndStockId(productId, id, stockDTO));
    }

    @ApiOperation(value = "Delete stock by stock ID of a specific product")
    @DeleteMapping("/{productId}/stocks/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteStockByProductIdAndStockId(@PathVariable Integer productId, @PathVariable Integer id) {
        stockService.deleteStockByProductIdAndStockId(productId, id);
        return ResponseEntity.ok().build();
    }
}