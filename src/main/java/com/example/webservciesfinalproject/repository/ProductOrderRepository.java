/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/25/2023
 * Time: 2:15 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.repository;

import com.example.webservciesfinalproject.dto.ProductOrderDTO;
import com.example.webservciesfinalproject.entity.Order;
import com.example.webservciesfinalproject.entity.ProductOrder;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {

    // Find all product orders by order ID
    List<ProductOrder> findByOrderId(Integer orderId);

    // Find all product orders by product ID
    List<ProductOrder> findByProductId(Integer productId);

    // Find a product order by order ID and product ID
    ProductOrder findByOrderIdAndProductId(Integer orderId, Integer productId);

    @Query("SELECT po FROM ProductOrder po WHERE po.order.customer.id = :customerId AND po.order.id = :orderId AND po.product.id = :productId")
    ProductOrder findByOrder_Customer_IdAndOrder_IdAndProduct_Id(@Param("customerId") Integer customerId, @Param("orderId") Integer orderId, @Param("productId") Integer productId);
    //ProductOrder findByOrder_Customer_IdAndOrder_IdAndProduct_Id(Integer customerId, Integer orderId, Integer productId);
    @Query("SELECT po FROM ProductOrder po WHERE po.order.customer.id = :customerId AND po.order.id = :orderId AND po.product.id = :productId")
    Optional<ProductOrder> findFirstByCustomerIdAndOrderIdAndProductId(@Param("customerId") Integer customerId, @Param("orderId") Integer orderId, @Param("productId") Integer productId);

    @Query("SELECT o FROM ProductOrder o WHERE o.order = :order AND o.id = :id")
    Optional<ProductOrder> findByOrderAndProduct_Id( @Param("order") Order order, @Param("id")Integer id);
    // Delete a product order by order ID and product ID
    void deleteByOrderIdAndProductId(Integer orderId, Integer productId);
}
//@Repository
//public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
//
//
//    Optional<ProductOrder> findByOrderIdAndProductId(Integer orderId, Integer productId);
//
//    @Query
//    List<ProductOrderDTO> findProductsByOrderAndCustomerId(Integer orderId, Integer customerId);
//
//    @Query
//    ProductOrderDTO findProductByOrderAndProductAndCustomerId(Integer orderId, Integer productId, Integer customerId);
//
//    @Query
//    ProductOrderDTO addProductToOrder(Integer orderId, ProductOrderDTO productOrderDTO);
//
//    @Query
//    ProductOrderDTO updateProductOfOrder(Integer orderId, Integer productId, ProductOrderDTO productOrderDTO);
//
//
//
//
//
//    @Modifying
//    @Query("delete from ProductOrder po where po.orderId = :orderId and po.productId = :productId")
//    void deleteProductOfOrder(@Param("orderId") Integer orderId, @Param("productId") Integer productId);
//
//    @Modifying
//    @Query("delete from ProductOrder po where po.orderId = :orderId and po.productId = :productId")
//    void deleteOrderOfProduct(@Param("orderId") Integer orderId, @Param("productId") Integer productId);
//
//    @Query
//    List<ProductOrderDTO> findOrdersByProductAndCustomerId(Integer productId, Integer customerId);
//
//    @Query
//    ProductOrderDTO findOrderByProductAndOrderAndCustomerId(Integer productId, Integer orderId, Integer customerId);
//
//    @Query
//    ProductOrderDTO addOrderToProduct(Integer productId, ProductOrderDTO productOrderDTO);
//
//    @Query
//    ProductOrderDTO updateOrderOfProduct(Integer productId, Integer orderId, ProductOrderDTO productOrderDTO);
//
////    @Query
////    void deleteOrderOfProduct(Integer productId, Integer orderId);
////
//}
