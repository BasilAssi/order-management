/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/25/2023
 * Time: 2:01 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
//@IdClass(ProductOrderKey.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @EmbeddedId
//    private ProductOrderKey id;

    private Integer quantity;
    private BigDecimal price;
    private BigDecimal vat;

//    @ManyToOne
//   // @MapsId("productId")
//    @JoinColumn(name = "productId")
//    Product product;
//
//    @ManyToOne
//  // @MapsId("orderId")
//    @JoinColumn(name = "orderId")
//    Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id" , referencedColumnName = "id" , nullable = false)

    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id" , referencedColumnName = "id" , nullable = false)
    private  Order order;

}
