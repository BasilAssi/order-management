/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/25/2023
 * Time: 2:03 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@Data
@Embeddable
public class ProductOrderKey implements Serializable {


//    @JoinColumn(name = "orderId")
//    private Order order;
//
//    @Column(name = "productId")
//    private Product product;
//
//    public ProductOrderKey(Order order, Product product) {
//        this.order = order;
//        this.product = product;
//    }
}
