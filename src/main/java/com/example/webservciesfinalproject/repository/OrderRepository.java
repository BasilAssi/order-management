/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/25/2023
 * Time: 2:13 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.repository;

import com.example.webservciesfinalproject.entity.Customer;
import com.example.webservciesfinalproject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer(Customer customer);
    Optional<Order> findByIdAndCustomer(Integer id, Customer customer);
}