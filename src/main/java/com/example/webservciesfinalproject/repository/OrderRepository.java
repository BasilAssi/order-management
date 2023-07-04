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
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer(Customer customer);
//   Optional<Order> findByCustomerAndOrderId(Customer customer, Integer id);


    @Query("SELECT o FROM Order o WHERE o.customer = :customer AND o.id = :id")
    Optional<Order> findByCustomerAndOrderId(@Param("customer") Customer customer, @Param("id") Integer id);
}