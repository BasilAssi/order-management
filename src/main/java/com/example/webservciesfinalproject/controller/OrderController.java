/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 7/1/2023
 * Time: 10:56 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.controller;

import com.example.webservciesfinalproject.dto.CustomerDTO;
import com.example.webservciesfinalproject.dto.OrderDTO;
import com.example.webservciesfinalproject.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

// The @RestController annotation informs Spring that this class is a controller that should process HTTP requests.
// The @RequestMapping("/api/v1/customers/{customerId}/orders") annotation maps this controller to the specified URL path.
@Api(tags = "Orders")
@RestController
@RequestMapping("/api/v1/customers/{customerId}/orders")
public class OrderController {

// The @Autowired annotation tells Spring to inject the OrderService into this controller.
    @Autowired
    private OrderService orderService;
    // This method retrieves all orders for a specific customer.
    // The @GetMapping annotation informs that this method should respond to HTTP GET requests.

    @ApiOperation(value = "Get all Orders by Customer")
    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrdersByCustomer(@PathVariable Integer customerId) {
        // Calling the getAllOrdersByCustomer method of the orderService.
        List<OrderDTO> orderDTOS = orderService.getAllOrdersByCustomer(customerId);

            for ( OrderDTO order: orderDTOS ) {
                // Linking each order with its respective products.
                Link ordersLink = linkTo(methodOn(ProductOrderController.class)
                        .getProductsOfOrder(order.getCustomerId() , order.getId()))
                        .withRel("productOrders");
                order.add(ordersLink);
            }
            // Returning the order list
            return ResponseEntity.ok(orderDTOS);

    }
    // This method fetches a specific order by its id for a specific customer.
    @ApiOperation(value = "Get  Order by Id ,  and Customer")
    @GetMapping("{id}")
    public ResponseEntity<OrderDTO> getOrderByIdAndCustomer(@PathVariable Integer id, @PathVariable Integer customerId) {
        // Calling the getOrderByIdAndCustomer method of the orderService.

        OrderDTO orderDTO = orderService.getOrderByIdAndCustomer(id, customerId);
        // Linking the order with its respective products.
        Link ordersLink = linkTo(methodOn(ProductOrderController.class)
                .getProductsOfOrder(orderDTO.getCustomerId() , orderDTO.getId()))
                .withRel("productOrders");
        orderDTO.add(ordersLink);
        // Returning the order
        return new ResponseEntity<>(orderDTO, HttpStatus.OK);
    }
    // This method creates a new order for a specific customer.
    @ApiOperation(value = "Post  Order by Id ,  and Customer")
    @PostMapping
    public ResponseEntity<OrderDTO> createOrderForCustomer(@PathVariable Integer customerId, @RequestBody OrderDTO orderDTO) {
        // Calling the createOrderForCustomer method of the orderService.
        OrderDTO newOrderDTO = orderService.createOrderForCustomer(customerId, orderDTO);
        // Returning the created order
        return new ResponseEntity<>(newOrderDTO, HttpStatus.CREATED);
    }
    // This method updates a specific order for a specific customer.
    @ApiOperation(value = "update  Order by Id ,  and Customer")
    @PutMapping("{id}")
    public ResponseEntity<OrderDTO> updateOrderOfCustomer(@PathVariable Integer id, @PathVariable Integer customerId, @RequestBody OrderDTO orderDTO) {
        // Calling the updateOrderOfCustomer method of the orderService.
        OrderDTO updatedOrderDTO = orderService.updateOrderOfCustomer(id, customerId, orderDTO);
        // Returning the updated order
        return new ResponseEntity<>(updatedOrderDTO, HttpStatus.OK);
    }
    // This method deletes a specific order for a specific customer.
    @ApiOperation(value = "Delete  Order by Id ,  and Customer")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderOfCustomer(@PathVariable Integer id, @PathVariable Integer customerId) {
        // Calling the deleteOrderOfCustomer method of the orderService.
        orderService.deleteOrderOfCustomer(id, customerId);
        // After successful deletion, it returns an HTTP 204 status code without body content
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}