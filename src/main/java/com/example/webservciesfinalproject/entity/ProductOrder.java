/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/25/2023
 * Time: 2:01 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    @DecimalMin(value = "2.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal price;

    @DecimalMin(value = "2.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal vat;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id" , referencedColumnName = "id" , nullable = false)

    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id" , referencedColumnName = "id" , nullable = false)
    private  Order order;

}
//    @EmbeddedId
//    private ProductOrderKey id;
//    @ManyToOne
//   // @MapsId("productId")
//    @JoinColumn(name = "productId")
//    Product product;
//
//    @ManyToOne
//  // @MapsId("orderId")
//    @JoinColumn(name = "orderId")
//    Order order;
