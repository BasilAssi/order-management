/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/28/2023
 * Time: 10:31 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.service.impl;



import com.example.webservciesfinalproject.dto.OrderDTO;
import com.example.webservciesfinalproject.entity.Customer;
import com.example.webservciesfinalproject.entity.Order;
import com.example.webservciesfinalproject.exception.ResourceNotFoundException;
import com.example.webservciesfinalproject.repository.CustomerRepository;
import com.example.webservciesfinalproject.repository.OrderRepository;
import com.example.webservciesfinalproject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<OrderDTO> getAllOrdersByCustomer(Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " ,"customerId" , customerId));

        return orderRepository.findByCustomer(customer).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderByIdAndCustomer(Integer id, Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "CustomerId" , customerId));

        Order order = orderRepository.findByIdAndCustomer(id, customer)
                .orElseThrow(() -> new ResourceNotFoundException("Order" ,"id" , id));
        return convertToDTO(order);
    }

    @Override
    public OrderDTO createOrderForCustomer(Integer customerId, OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer" , "customerId" , customerId));

        Order order = convertToEntity(orderDTO);
        order.setCustomer(customer);
        return convertToDTO(orderRepository.save(order));
    }

    @Override
    public OrderDTO updateOrderOfCustomer(Integer id, Integer customerId, OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " ,"customerId",customerId));

        Order order = orderRepository.findByIdAndCustomer(id, customer)
                .orElseThrow(() -> new ResourceNotFoundException("Order" ,"id" ,id));

        order = convertToEntity(orderDTO);
        order.setCustomer(customer);
        return convertToDTO(orderRepository.save(order));
    }

    @Override
    public void deleteOrderOfCustomer(Integer id, Integer customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer " ,"customerId",customerId));

        Order order = orderRepository.findByIdAndCustomer(id, customer)
                .orElseThrow(() -> new ResourceNotFoundException("Order" ,"id" ,id));
        orderRepository.delete(order);
    }

    // Method to convert Order to OrderDTO
    private OrderDTO convertToDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        if (order.getCustomer() != null) {
            orderDTO.setCustomerId(order.getCustomer().getId());
        }
        orderDTO.setOrderAt(order.getOrderAt());
        return orderDTO;
    }

    // Method to convert OrderDTO to Order
    private Order convertToEntity(OrderDTO orderDTO) {
        Order order = new Order();
        order.setId(orderDTO.getId());
        if (orderDTO.getCustomerId() != null) {
            Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Customer","customerId" , orderDTO.getCustomerId()));
            order.setCustomer(customer);
        }
        order.setOrderAt(orderDTO.getOrderAt());
        return order;
    }
}
