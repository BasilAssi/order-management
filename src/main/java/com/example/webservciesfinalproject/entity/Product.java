/**
 * Created By: Basil Assi
 * ID Number: 1192308
 * Date: 6/25/2023
 * Time: 1:59 PM
 * Project Name: WebServciesFinalProject
 */

package com.example.webservciesfinalproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String slug;
    private String name;
    private String reference;
    @DecimalMin(value = "2.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal price;
    @DecimalMin(value = "2.0", inclusive = true)
    @DecimalMax(value = "10.0", inclusive = true)
    private BigDecimal vat;
    private Boolean stockable;

    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<ProductOrder> productOrders;


}

